package com.hamy.currencyconverter.networking.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.views.activities.MainActivity

object WorkerUtils {
    fun makeStatusNotification(message: String?, context: Context) {
        // Make a channel if necessary
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            // Add the channel
            (context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).apply {
                createNotificationChannel(
                    NotificationChannel(
                        Constants.CHANNEL_ID,
                        Constants.VERBOSE_NOTIFICATION_CHANNEL_NAME,
                        NotificationManager.IMPORTANCE_HIGH
                    ).apply {
                        description = Constants.VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION
                    }
                )
            }
        }

        // Create an explicit intent for an Activity in your app
        Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            // Show the notification
            NotificationManagerCompat.from(context).notify(
                Constants.NOTIFICATION_ID, NotificationCompat.Builder(context, Constants.CHANNEL_ID)
                    .setSmallIcon(R.drawable.icon)
                    .setContentTitle(Constants.NOTIFICATION_TITLE)
                    .setContentText(message)
                    .setPriority(NotificationCompat.PRIORITY_HIGH) // Set the intent that will fire when the user taps the notification
                    .setContentIntent(
                        PendingIntent.getActivity(context, 0, this, if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) PendingIntent.FLAG_MUTABLE else 0)
                    )
                    .setVibrate(LongArray(0))
                    .setAutoCancel(true).build()
            )
        }
    }

    /**
     * Method for sleeping for a fixed about of time to emulate slower work
     */
    fun sleep() {
        try {
            Thread.sleep(Constants.DELAY_TIME_MILLIS, 0)
        } catch (_: InterruptedException) {
        }
    }
}