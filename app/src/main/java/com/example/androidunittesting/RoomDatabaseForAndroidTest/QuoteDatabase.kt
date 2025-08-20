package com.example.androidunittesting.RoomDatabaseForAndroidTest

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao():QuotesDao
}