package com.example.androidunittesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.androidunittesting.QuoteFyAppForAndroidTest.Quote
import com.example.androidunittesting.QuoteFyAppForAndroidTest.QuoteManager
import com.google.gson.JsonSyntaxException
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.FileNotFoundException

class QuoteDataManagerTest {

    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets() {

        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun testPopulateQuoteFromAssets_InvalidJSON_expected_Exception() {

        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "malformed.json")
    }

    @Test
    fun testPopulateQuoteFromAssets_ValidJSON_expected_Count() {

        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context, "quotes.json")
        assertEquals(1643, quoteManager.quoteList.size)
    }

    @Test
    fun testPreviousQuote_expected_CorrectQuote() {
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("This is a first quote", "1"),
                Quote("This is a second quote", "2"),
                Quote("This is a third quote", "3"),

                )
        )
        //Act
        val quote = quoteManager.getPreviousQuote()
        //Assert
        assertEquals("1",quote.author)
    }

    @Test
    fun testNextQuote_expected_NextQuote() {
        //Arrange
        val quoteManager = QuoteManager()
        quoteManager.populateQuotes(
            arrayOf(
                Quote("This is a first quote", "1"),
                Quote("This is a second quote", "2"),
                Quote("This is a third quote", "3"),

                )
        )
        //Act
        val quote = quoteManager.getNextQuote()
        //Assert
        assertEquals("2",quote.author)
    }
}