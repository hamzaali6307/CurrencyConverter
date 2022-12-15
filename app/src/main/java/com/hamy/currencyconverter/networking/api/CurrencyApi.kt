package com.hamy.currencyconverter.networking.api

import com.hamy.currencyconverter.networking.contants.Constants.CURRENCY
import com.hamy.currencyconverter.networking.contants.Constants.LATEST
import com.hamy.currencyconverter.views.model.CurrencyConvert
import com.hamy.currencyconverter.views.model.CurrencyName
import com.hamy.currencyconverter.views.model.CurrencyRates
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CurrencyApi {
    @GET(CURRENCY)
    suspend fun getCurrency(): Response<CurrencyName>

    @GET(LATEST)
    suspend fun getCurrencyRates(): Response<CurrencyRates>

    @GET
    suspend fun getCurrencyExchange(@Url url:String): Response<CurrencyConvert>

    @GET(LATEST)
    fun getRates(): Call<CurrencyRates>

}