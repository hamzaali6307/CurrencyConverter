package com.hamy.currencyconverter.networking.viewModel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.networking.Repository.CurrencyRepo
import com.hamy.currencyconverter.networking.utils.MyApplication
import com.hamy.currencyconverter.networking.utils.Resource
import com.hamy.currencyconverter.networking.utils.Utils.hasInternetConnected
import com.hamy.currencyconverter.views.model.CurrencyName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    app: Application,
    private val newsRepository: CurrencyRepo,
) : AndroidViewModel(app) {

    val currencyList: MutableLiveData<Resource<CurrencyName>> = MutableLiveData()
    var currencyName: CurrencyName? = null

    fun getCurrency() = viewModelScope.launch {
        safeCurrencyCall()
    }

    private fun handleNewsResponse(response: Response<CurrencyName>): Resource<CurrencyName> {
        if (response.isSuccessful) {
            response.body()?.let { newsResponse ->
                currencyName = (newsResponse)
                return Resource.Success(currencyName ?: newsResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private suspend fun safeCurrencyCall() {
        currencyList.postValue(Resource.Loading())
        try {
            if (hasInternetConnected(getApplication())) {
                currencyList.postValue(handleNewsResponse(newsRepository.getCurrency()))
            } else {
                currencyList.postValue(Resource.Error(getApplication<MyApplication>().getString(R.string.internet_not_connected)))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> currencyList.postValue(Resource.Error(getApplication<MyApplication>().getString(
                    R.string.network_failure_error)))
                else -> currencyList.postValue(Resource.Error(t.message.toString()))
            }
        }
    }


}