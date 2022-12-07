package com.hamy.currencyconverter.networking.api

import com.example.example.CurrencyRates
import com.hamy.currencyconverter.networking.contants.Constants.CURRENCY
import com.hamy.currencyconverter.networking.contants.Constants.LATEST
import com.hamy.currencyconverter.views.model.CurrencyName
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApi {

    @GET(CURRENCY)
    suspend fun getCurrency(): Response<CurrencyName>

    @GET(LATEST)
    suspend fun getCurrencyRates(): Response<CurrencyRates>

}