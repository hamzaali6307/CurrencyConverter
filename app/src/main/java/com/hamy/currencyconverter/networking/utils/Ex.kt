package com.hamy.currencyconverter.networking.utils

import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

fun log(msg: Any?) {
    Log.e("TAG", msg.toString())
}

fun showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}

fun setMultipleViewsVisibility(isVisible: Boolean, vararg view: View) {
    for (v in view) {
        if (isVisible) v.visible() else v.gone()
    }
}

fun View.isVisible(isVisible: Boolean) {
    if (isVisible) visible() else gone()
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.OnClickListener.initMultipleClickListener(vararg view: View) {
    for (v in view) {
        v.setOnClickListener(this)
    }
}

fun <T : Serializable?> Intent.getSerializable(key: String, m_class: Class<T>): T {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        this.getSerializableExtra(key, m_class)!!
    else
        this.getSerializableExtra(key) as T
}
