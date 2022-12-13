package com.hamy.currencyconverter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hamy.currencyconverter.database.dao.CurrencyDao
import com.hamy.currencyconverter.networking.utils.DateTypeConverter
import com.hamy.currencyconverter.views.model.CurrencyValue

@Database(entities = [CurrencyValue::class], version = 1)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun routineDao(): CurrencyDao
    companion object {
        var INSTANCE: AppDatabase? = null
        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "myDB").allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}