package com.hamy.currencyconverter.views.model

import com.google.gson.annotations.SerializedName

data class CurrencyConvert(
    @SerializedName("error" ) var error: Boolean,
    @SerializedName("status" ) var status: Long,
    @SerializedName("message" ) var message: String,
    @SerializedName("description" ) var description: String
)