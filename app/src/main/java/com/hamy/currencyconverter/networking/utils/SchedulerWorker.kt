package com.hamy.currencyconverter.networking.utils

import android.content.Context
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.database.AppDatabase
import com.hamy.currencyconverter.database.dao.CurrencyDao
import com.hamy.currencyconverter.networking.Repository.CurrencyRatesRepo
import com.hamy.currencyconverter.networking.api.CurrencyApi
import com.hamy.currencyconverter.networking.utils.SchedulerWorker
import com.hamy.currencyconverter.networking.viewModel.CurrencyRatesViewModel
import com.hamy.currencyconverter.views.model.CurrencyRates
import com.hamy.currencyconverter.views.model.CurrencyValue
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class SchedulerWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    private lateinit var currencyRatesViewModel: CurrencyRatesViewModel
    private var database: CurrencyDao? = null
    private lateinit var  currencyApi: CurrencyApi


    @OptIn(DelicateCoroutinesApi::class)
    override fun doWork(): Result {
        currencyRatesViewModel.getCurrencyRates()
        return try {
            //create a call to network
            GlobalScope.launch {
                currencyRatesViewModel =
                    ViewModelProvider(applicationContext)[CurrencyRatesViewModel::class.java]
            }

            val call: Call<List<CurrencyRates>> = currencyApi.getRates()
            database = AppDatabase.getAppDataBase(applicationContext)?.routineDao()
            val response: Response<List<CurrencyRates>?> = call.execute()
            if (response.isSuccessful && response.body() != null && response.body()!!.isNotEmpty() && response.body()!!.isNotEmpty()
            ) {
                val data = WorkerUtils.toJson(response.body())

                //delete existing book data
              //  database?.updateSell(response.body().)

                WorkerUtils.makeStatusNotification(
                    applicationContext.getString(R.string.new_data_available),
                    applicationContext
                )
                Result.success()
            } else {
                Result.retry()
            }
        } catch (e: Throwable) {
            e.printStackTrace()

            Result.failure()
        }
        WorkerUtils.sleep()
    }

    override fun onStopped() {
        super.onStopped()
        Log.i(TAG, "OnStopped called for this worker")
    }

    companion object {
        private val TAG = SchedulerWorker::class.java.simpleName
    }
}