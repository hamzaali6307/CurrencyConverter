package com.hamy.currencyconverter.views.activities

import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.BuildCompat
import com.hamy.currencyconverter.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@BuildCompat.PrereleaseSdkCheck @AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)

        when {
            BuildCompat.isAtLeastT() -> {
                onBackInvokedDispatcher.registerOnBackInvokedCallback(
                    OnBackInvokedDispatcher.PRIORITY_DEFAULT) {
                    finish()
                }
            }
            else -> {
                onBackPressedDispatcher.addCallback(this /* lifecycle owner */) {
                    finish()
                }
            }
        }
    }
}