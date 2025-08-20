package com.example.androidunittesting

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.androidunittesting.RoomDatabaseForAndroidTest.Quote
import com.example.androidunittesting.RoomDatabaseForAndroidTest.QuoteDatabase
import com.example.androidunittesting.RoomDatabaseForAndroidTest.QuotesDao
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuotesDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var quoteDatabase: QuoteDatabase
    private lateinit var quotesDao: QuotesDao

    @Before
    fun setUp() {

        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), QuoteDatabase::class.java
        ).allowMainThreadQueries().build()

        quotesDao = quoteDatabase.quoteDao()
    }

    @Test
    fun insert_Quote_Expected_Single_Quote() = runBlocking {
        val quote = Quote(0, "This is a test quote", "Mansukh")
        quotesDao.insertQuote(quote)

        val result = quotesDao.getQuotes().getOrAwaitValue()
        Assert.assertEquals(1, result.size)
        Assert.assertEquals("This is a test quote", result[0].text)

    }

    @Test
    fun delete_Quote_expected_NoResults() = runBlocking {
        val quote = Quote(0, "This is a test quote", "Mansukh")
        quotesDao.insertQuote(quote)

        quotesDao.delete()

        val result = quotesDao.getQuotes().getOrAwaitValue()
        Assert.assertEquals(0, result.size)
    }


    @After
    fun tearDown() {
        quoteDatabase.close()
    }
}