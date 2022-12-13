package com.hamy.currencyconverter.networking.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.hamy.currencyconverter.networking.utils.DefaultPreferences.Companion.dataStore
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore("task_prefernces")

class DefaultPreferences(context: Context) {

    companion object {
        var dataStore: DataStore<Preferences>? = null
    }

    init {
        dataStore = context.dataStore
    }
}

const val FROM_CURRENCY_CODE = "from_code"
const val FROM_CURRENCY_RATE = "from_rate"
const val TO_CURRENCY_RATE = "to_rate"
const val TO_CURRENCY_CODE = "to_code"


suspend fun getFromCurrencyCode(): String? {
    val value = dataStore?.data?.first()?.get(stringPreferencesKey(FROM_CURRENCY_CODE))
    if (value.isNullOrEmpty()) {
        return value?.ifEmpty { null }
    }
    return value
}

suspend fun setFromCurrencyCode(currency_code: String) {
    val dataStoreKey = stringPreferencesKey(FROM_CURRENCY_CODE)
    dataStore?.edit { settings ->
        settings[dataStoreKey] = currency_code
    }
}

suspend fun getFromCurrencyRate(): String? {
    val value = dataStore?.data?.first()?.get(stringPreferencesKey(FROM_CURRENCY_RATE))
    if (value.isNullOrEmpty()) {
        return value?.ifEmpty { null }
    }
    return value
}

suspend fun setFromCurrencyRate(currency_rate: String) {
    val dataStoreKey = stringPreferencesKey(FROM_CURRENCY_RATE)
    dataStore?.edit { settings ->
        settings[dataStoreKey] = currency_rate
    }
}

suspend fun getToCurrencyCode(): String? {
    val value = dataStore?.data?.first()?.get(stringPreferencesKey(TO_CURRENCY_CODE))
    if (value.isNullOrEmpty()) {
        return value?.ifEmpty { null }
    }
    return value
}

suspend fun setToCurrencyCode(currency_code: String) {
    val dataStoreKey = stringPreferencesKey(TO_CURRENCY_CODE)
    dataStore?.edit { settings ->
        settings[dataStoreKey] = currency_code
    }
}

    suspend fun getToCurrencyRate(): String? {
        val value = dataStore?.data?.first()?.get(stringPreferencesKey(TO_CURRENCY_RATE))
        if (value.isNullOrEmpty()) {
            return value?.ifEmpty { null }
        }
        return value
    }

    suspend fun setToCurrencyRate(currency_code: String) {
        val dataStoreKey = stringPreferencesKey(TO_CURRENCY_RATE)
        dataStore?.edit { settings ->
            settings[dataStoreKey] = currency_code
        }
    }






