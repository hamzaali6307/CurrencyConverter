package com.hamy.currencyconverter.networking.Repository

import com.example.example.CurrencyRates
import com.hamy.currencyconverter.networking.RetroInstance
import com.hamy.currencyconverter.views.model.CurrencyName
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class CurrencyRatesRepo @Inject constructor() {

    suspend fun getCurrencyRates() : Response<CurrencyRates> {
       return RetroInstance.api.getCurrencyRates()
    }
}