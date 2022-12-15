package com.hamy.currencyconverter.views.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "currency")
data class CurrencyValue(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val currencyCode: String,val currencyValue: String,val defaultRate :String? = "0.0"  ) :
    Serializable