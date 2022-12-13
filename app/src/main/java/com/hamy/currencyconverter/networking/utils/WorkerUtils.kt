/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hamy.currencyconverter.networking.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hamy.currencyconverter.views.model.CurrencyValue
import android.os.Build
import android.app.NotificationManager
import android.app.NotificationChannel
import android.content.Intent
import com.hamy.currencyconverter.views.activities.MainActivity
import android.app.PendingIntent
import android.content.Context
import androidx.core.app.NotificationCompat
import com.hamy.currencyconverter.R
import androidx.core.app.NotificationManagerCompat
import com.hamy.currencyconverter.views.model.CurrencyRates

object WorkerUtils {
    private val TAG = WorkerUtils::class.java.simpleName
    private val gson = Gson()
    private val currencyRates = object : TypeToken<List<CurrencyRates?>?>() {}.type
    fun makeStatusNotification(message: String?, context: Context) {

        // Make a channel if necessary
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library
            val name = Constants.VERBOSE_NOTIFICATION_CHANNEL_NAME
            val description = Constants.VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(Constants.CHANNEL_ID, name, importance)
            channel.description = description

            // Add the channel
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        // Create an explicit intent for an Activity in your app
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        // Create the notification
        val builder = NotificationCompat.Builder(context, Constants.CHANNEL_ID)
            .setSmallIcon(R.drawable.icon)
            .setContentTitle(Constants.NOTIFICATION_TITLE)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH) // Set the intent that will fire when the user taps the notification
            .setContentIntent(pendingIntent)
            .setVibrate(LongArray(0))
            .setAutoCancel(true)

        // Show the notification
        NotificationManagerCompat.from(context).notify(Constants.NOTIFICATION_ID, builder.build())
    }

    /**
     * Method for sleeping for a fixed about of time to emulate slower work
     */
    fun sleep() {
        try {
            Thread.sleep(Constants.DELAY_TIME_MILLIS, 0)
        } catch (e: InterruptedException) {
            //  Timber.d(e.getMessage());
        }
    }

    //TODO: replace with Generics for params, return type and TypeToken Params
    fun toJson(currency: List<CurrencyRates?>?): String {
        return gson.toJson(currency, currencyRates)
    }

    fun fromJson(data: String?): List<CurrencyRates> {
        return gson.fromJson(data, currencyRates)
    }
}