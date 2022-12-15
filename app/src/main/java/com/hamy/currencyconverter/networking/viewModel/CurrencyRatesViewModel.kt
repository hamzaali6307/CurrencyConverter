package com.hamy.currencyconverter.networking.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.work.*
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.networking.Repository.CurrencyRatesRepo
import com.hamy.currencyconverter.networking.utils.Constants
import com.hamy.currencyconverter.networking.utils.MyApplication
import com.hamy.currencyconverter.networking.utils.Resource
import com.hamy.currencyconverter.networking.utils.SchedulerWorker
import com.hamy.currencyconverter.networking.utils.Utils.hasInternetConnected
import com.hamy.currencyconverter.views.model.CurrencyRates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@HiltViewModel
class CurrencyRatesViewModel @Inject constructor(
    app: Application,
    private val currencyRatesRepo: CurrencyRatesRepo,
) : AndroidViewModel(app) {

    val currencyRatesList: MutableLiveData<Resource<CurrencyRates>> = MutableLiveData()
    var currencyName: CurrencyRates? = null
    private val mWorkManager: WorkManager = WorkManager.getInstance(app)


    fun getCurrencyRates() = viewModelScope.launch {
        safeCurrencyRatesCall()
        scheduler()
    }

    fun scheduler() {

//        val mywork = OneTimeWorkRequest.Builder(SchedulerWorker::class.java)  // 1 time request for rates update
//            .setInitialDelay(1, TimeUnit.MINUTES)
//            .build()
//        WorkManager.getInstance(getApplication()).enqueue(mywork)

        // after 30 mint rates update
        mWorkManager.enqueueUniquePeriodicWork(
            Constants.SYNC_DATA_WORK_NAME, ExistingPeriodicWorkPolicy.KEEP,
            PeriodicWorkRequest.Builder(
                SchedulerWorker::class.java, 30, TimeUnit.MINUTES
            )
                .addTag(Constants.TAG_SYNC_DATA)
                .setConstraints(
                    Constraints.Builder()
                        .setRequiredNetworkType(NetworkType.CONNECTED)
                        .build()
                ) // setting a backoff on case the work needs to retry
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    PeriodicWorkRequest.MIN_BACKOFF_MILLIS,
                    TimeUnit.MILLISECONDS
                )
                .build()
        )
    }


    private fun handleNewsResponse(response: Response<CurrencyRates>): Resource<CurrencyRates> {
        if (response.isSuccessful) {
            response.body()?.let { resp ->
                currencyName = (resp)
                return Resource.Success(currencyName ?: resp)
            }
        }
        return Resource.Error(response.message())
    }

    private suspend fun safeCurrencyRatesCall() {
        currencyRatesList.postValue(Resource.Loading())
        try {

            currencyRatesList.postValue(
                when {
                    hasInternetConnected(getApplication()) -> handleNewsResponse(currencyRatesRepo.getCurrencyRates())
                    else -> Resource.Error(getApplication<MyApplication>().getString(R.string.internet_not_connected))
                }
            )

        } catch (t: Throwable) {
            when (t) {
                is IOException -> currencyRatesList.postValue(
                    Resource.Error(
                        getApplication<MyApplication>().getString(
                            R.string.network_failure_error
                        )
                    )
                )
                else -> currencyRatesList.postValue(Resource.Error(t.message.toString()))
            }
        }
    }
}