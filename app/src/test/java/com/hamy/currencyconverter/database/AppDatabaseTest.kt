package com.hamy.currencyconverter.database

import android.content.Context
import androidx.datastore.core.IOException
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.hamy.currencyconverter.database.dao.CurrencyDao
import com.hamy.currencyconverter.views.model.CurrencyValue
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AppDatabaseTest {
    private lateinit var userDao: CurrencyDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        userDao = db.routineDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertIntoDatabase() {
        val currency = CurrencyValue(1, "AED", "United Arab Emirates Dirham", "3.77")
        userDao.insertSellList(currency)
        val currencyData = userDao.checkCurrencyAvailable("AED")
        Assert.assertEquals(currencyData.currencyCode, equalTo(currency.currencyCode))
    }

    @Test
    fun updateIntoDatabase() {
        val currency = CurrencyValue(1, "AED", "United Arab Emirates Dirham", "3.77")
        userDao.updateSell("AED", currency.defaultRate.toString())
        val currencyData = userDao.checkCurrencyAvailable("AED")
        Assert.assertEquals(currencyData.currencyCode, equalTo(currency.currencyCode))
    }

    @Test
    fun getCurrencyListDatabase() {
        val list = userDao.getSellList()
        Assert.assertEquals(list,list)
    }
}