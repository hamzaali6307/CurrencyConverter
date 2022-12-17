package com.hamy.currencyconverter.networking.utils

import androidx.room.TypeConverter
import java.util.*

class DateTypeConverter {
    @TypeConverter
    fun fromDoubleToString(value: Double?): String? {
        return value?.toString()
    }

    @TypeConverter
    fun stringToDouble(value: String?): Double? {
        return value?.toDouble()
    }
}