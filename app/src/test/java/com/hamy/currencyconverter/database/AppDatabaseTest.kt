package com.hamy.currencyconverter.database

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.datastore.core.IOException
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.hamy.currencyconverter.database.dao.CurrencyDao
import com.hamy.currencyconverter.views.model.CurrencyValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.equalTo
import org.junit.*
import org.junit.Assert.*

import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@SmallTest
@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var userDao: CurrencyDao
    private lateinit var db: AppDatabase

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).allowMainThreadQueries()
            .build()
        userDao = db.routineDao()
    }

    @Test
    fun routineDao() {
    }

    @Test
    fun insertIntoDatabase() = runTest {
        launch {
            val currency = CurrencyValue(1, "AED", "United Arab Emirates Dirham", "3.77")
            userDao.insertSellList(currency)
            val currencyData = userDao.checkCurrencyAvailable("AED")
            Assert.assertEquals(currencyData.currencyCode, equalTo(currency.currencyCode))
        }
    }

    @Test
    fun updateIntoDatabase() = runBlocking {
        val currency = CurrencyValue(1, "AED", "United Arab Emirates Dirham", "3.77")
        userDao.updateSell("AED", currency.defaultRate.toString())
        val currencyData = userDao.checkCurrencyAvailable("AED")
        Assert.assertEquals(currencyData.currencyCode, equalTo(currency.currencyCode))
    }

    @Test
    fun getCurrencyListDatabase() = runBlocking {
        val list = userDao.getSellList()
        Assert.assertEquals(list[0].currencyCode, currencyList()[0].currencyCode)
    }

    private fun currencyList(  // updating rates after 30 Mint of interval
    ): ArrayList<CurrencyValue> {
        return arrayListOf<CurrencyValue>().apply {
            apply {
                add(CurrencyValue(1, "AED", "United Arab Emirates Dirham", "3.6729"))
            }
        }
    }
}