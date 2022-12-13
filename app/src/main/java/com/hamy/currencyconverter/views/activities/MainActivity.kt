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
    private fun scheduler() {

        mWorkManager?.enqueueUniquePeriodicWork(
            Constants.SYNC_DATA_WORK_NAME, ExistingPeriodicWorkPolicy.KEEP,
            PeriodicWorkRequest.Builder(
                SchedulerWorker::class.java, 15, TimeUnit.MINUTES
            )
                .addTag(Constants.TAG_SYNC_DATA)
                .setConstraints(
                    Constraints.Builder()
                        .setRequiredNetworkType(NetworkType.CONNECTED)
                        .build()) // setting a backoff on case the work needs to retry
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    PeriodicWorkRequest.MIN_BACKOFF_MILLIS,
                    TimeUnit.MILLISECONDS
                )
                .build()
        )
    }
}