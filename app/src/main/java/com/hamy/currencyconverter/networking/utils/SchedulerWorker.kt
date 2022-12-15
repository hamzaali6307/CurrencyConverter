package com.hamy.currencyconverter.networking.utils

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.hamy.currencyconverter.R
import com.hamy.currencyconverter.database.AppDatabase
import com.hamy.currencyconverter.database.dao.CurrencyDao
import com.hamy.currencyconverter.networking.api.CurrencyApi
import com.hamy.currencyconverter.networking.viewModel.CurrencyRatesViewModel
import com.hamy.currencyconverter.views.model.CurrencyRates
import retrofit2.Response

class SchedulerWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    private var database: CurrencyDao? = null
    private lateinit var  currencyApi: CurrencyApi


    override fun doWork(): Result {
        return try {

            database = AppDatabase.getAppDataBase(applicationContext)?.routineDao()

            val response: Response<List<CurrencyRates>?> = currencyApi.getRates().execute()
            if (response.isSuccessful && response.body() != null && response.body()!!.isNotEmpty() && response.body()!!.isNotEmpty()
            ) {
              //  val data = WorkerUtils.toJson(response.body())
                Log.d("myResponse",response.body().toString())

                WorkerUtils.makeStatusNotification(
                    applicationContext.getString(R.string.new_data_available),
                    applicationContext
                )
                Result.success()
            } else {
                Result.retry()
            }
        } catch (e: Throwable) {
            e.printStackTrace()

            Result.failure()
        }
        WorkerUtils.sleep()
    }

    override fun onStopped() {
        super.onStopped()
        Log.i(TAG, "OnStopped called for this worker")
    }

    companion object {
        private val TAG = SchedulerWorker::class.java.simpleName
    }
}