package com.hamy.currencyconverter.networking.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.example.CurrencyRates
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.networking.Repository.CurrencyRatesRepo
import com.hamy.currencyconverter.networking.utils.MyApplication
import com.hamy.currencyconverter.networking.utils.Resource
import com.hamy.currencyconverter.networking.utils.Utils.hasInternetConnected
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CurrencyRatesViewModel @Inject constructor(
    app: Application,
    private val currencyRatesRepo: CurrencyRatesRepo,
) : AndroidViewModel(app) {

    val currencyRatesList: MutableLiveData<Resource<CurrencyRates>> = MutableLiveData()
    var currencyName: CurrencyRates? = null

    fun getCurrencyRates() = viewModelScope.launch {
        safeCurrencyRatesCall()
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
            if (hasInternetConnected(getApplication())) {
                currencyRatesList.postValue(handleNewsResponse(currencyRatesRepo.getCurrencyRates()))
            } else {
                currencyRatesList.postValue(Resource.Error(getApplication<MyApplication>().getString(R.string.internet_not_connected)))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> currencyRatesList.postValue(Resource.Error(getApplication<MyApplication>().getString(
                    R.string.network_failure_error)))
                else -> currencyRatesList.postValue(Resource.Error(t.message.toString()))
            }
        }
    }



}