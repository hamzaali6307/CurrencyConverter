package com.hamy.currencyconverter.networking.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.networking.Repository.CurrencyConvertRepo
import com.hamy.currencyconverter.networking.utils.MyApplication
import com.hamy.currencyconverter.networking.utils.Resource
import com.hamy.currencyconverter.networking.utils.Utils.hasInternetConnected
import com.hamy.currencyconverter.views.model.CurrencyConvert
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(
    app: Application,
    private val newsRepository: CurrencyConvertRepo,
) : AndroidViewModel(app) {

    val currencyList: MutableLiveData<Resource<CurrencyConvert>> = MutableLiveData()
    private var currencyName: CurrencyConvert? = null

    fun getCurrencyRate(rate: Double, from: String, to: String) = viewModelScope.launch {
        safeCurrencyCall(rate, from, to)
    }

    private fun handleNewsResponse(response: Response<CurrencyConvert>): Resource<CurrencyConvert> {
        if (response.isSuccessful) {
            response.body()?.let { newsResponse ->
                currencyName = (newsResponse)
                return Resource.Success(currencyName ?: newsResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private suspend fun safeCurrencyCall(rate: Double, from: String, to: String) {
        currencyList.postValue(Resource.Loading())
        try {
            currencyList.postValue(
                when {
                    hasInternetConnected(getApplication()) -> handleNewsResponse(newsRepository.getCurrencyExchange(rate, from, to))
                    else -> Resource.Error(
                        getApplication<MyApplication>().getString(R.string.internet_not_connected)
                    )
                }
            )

        } catch (t: Throwable) {
            when (t) {
                is IOException -> currencyList.postValue(
                    Resource.Error(
                        getApplication<MyApplication>().getString(
                            R.string.network_failure_error
                        )
                    )
                )
                else -> currencyList.postValue(Resource.Error(t.message.toString()))
            }
        }
    }
}