package com.hamy.currencyconverter.database.dao

import androidx.room.*
import com.hamy.currencyconverter.views.model.CurrencyValue

@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSellList(routine: CurrencyValue)

    @Query("UPDATE currency SET defaultRate = :rates WHERE currencyCode=:currencyCode")
    fun updateSell(rates: String,currencyCode :String )

    @Delete
    fun deleteSell(routine: CurrencyValue)

    @Query("Select * from currency")
    fun getSellList(): List<CurrencyValue>
}