package com.hamy.currencyconverter.networking.utils

import android.view.View
import com.example.example.Currency
import com.hamy.currencyconverter.views.model.CurrencyName
import com.hamy.currencyconverter.views.model.CurrencyValue

object Utils {

    var BUNDLE_TITLE = ""

    fun View.OnClickListener.initMultipleViewsClickListener(vararg view: View) {
        for (v in view) {
            v.setOnClickListener (this)
        }
    }
}