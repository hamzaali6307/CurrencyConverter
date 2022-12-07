package com.hamy.currencyconverter.networking.Repository

import com.hamy.currencyconverter.networking.RetroInstance
import com.hamy.currencyconverter.views.model.CurrencyName
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Response
import javax.inject.Inject

@ActivityRetainedScoped
class CurrencyRepo @Inject constructor() {

    suspend fun getCurrency() : Response<CurrencyName> {
       return RetroInstance.api.getCurrency()
    }
}