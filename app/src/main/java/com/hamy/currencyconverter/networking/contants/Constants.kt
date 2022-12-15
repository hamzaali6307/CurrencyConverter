package com.hamy.currencyconverter.networking.contants

import com.hamy.currencyconverter.networking.utils.Utils.currencyFrom
import com.hamy.currencyconverter.networking.utils.Utils.currencyTo
import com.hamy.currencyconverter.networking.utils.Utils.currency

object Constants {
    const val BASE_URL = "https://openexchangerates.org/"
    const val APP_ID = "9413c900dfc548a4921d735474f86b0b"
    const val LATEST = "api/latest.json?app_id=$APP_ID"
    const val CURRENCY = "api/currencies.json?app_id=$APP_ID"
    const val CONVERT = "api/convert.json"


}