package com.hamy.currencyconverter.networking.Repository

import com.hamy.currencyconverter.networking.RetroInstance
import com.hamy.currencyconverter.networking.contants.Constants
import com.hamy.currencyconverter.networking.contants.Constants.CONVERT
import com.hamy.currencyconverter.networking.utils.Utils
import com.hamy.currencyconverter.views.model.CurrencyConvert
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class CurrencyConvertRepo @Inject constructor() {

    suspend fun getCurrencyExchange(rate: Double, from: String, to: String): Response<CurrencyConvert> {
       return RetroInstance.api.getCurrencyExchange("$CONVERT/$rate/$from/$to?app_id=${Constants.APP_ID}")
    }
}