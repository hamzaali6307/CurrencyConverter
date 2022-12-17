package com.hamy.currencyconverter.views.model

import com.google.gson.annotations.SerializedName
import com.hamy.currencyconverter.views.model.Rates

data class CurrencyRates(
  @SerializedName("disclaimer") var disclaimer: String? = null,
  @SerializedName("license") var license: String? = null,
  @SerializedName("timestamp") var timestamp: Int? = null,
  @SerializedName("base") var base: String? = null,
  @SerializedName("rates") var rates: Rates? = Rates(),
  )