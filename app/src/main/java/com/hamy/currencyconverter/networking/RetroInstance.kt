package com.hamy.currencyconverter.networking


import com.hamy.currencyconverter.networking.api.CurrencyApi
import com.hamy.currencyconverter.networking.contants.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object {
        private val retrofit by lazy {

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            setLevel(HttpLoggingInterceptor.Level.BODY)
                        })
                        .build()
                )
                .build()
        }

        val api: CurrencyApi by lazy {
            retrofit.create(CurrencyApi::class.java)
        }
    }
}