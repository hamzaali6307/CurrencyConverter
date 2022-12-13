package com.hamy.currencyconverter.views.model

import java.io.Serializable

data class CurrencyValue(val currencyCode: String,val currencyValue: String,val defaultRate :Double? = 0.0  ) :
    Serializable
