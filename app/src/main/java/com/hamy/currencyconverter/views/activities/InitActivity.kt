package com.hamy.currencyconverter.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.hamy.currencyconverter.R

class InitActivity : AppCompatActivity(R.layout.activity_init) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({ /* Create an Intent that will start the Menu-Activity. */
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}