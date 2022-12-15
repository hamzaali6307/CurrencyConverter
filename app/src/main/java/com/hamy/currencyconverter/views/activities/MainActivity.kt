package com.hamy.currencyconverter.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import com.hamy.currencyconverter.databinding.ActivityMainBinding
import com.hamy.currencyconverter.networking.utils.Constants
import com.hamy.currencyconverter.networking.utils.SchedulerWorker
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var mWorkManager: WorkManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
        mWorkManager = WorkManager.getInstance(this)

    }
}