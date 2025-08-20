package com.example.androidunittesting.QuoteFyAppForAndroidTest

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainViewModel(val context: Context): ViewModel() {
    private var quoteList: Array<QuoteData> = emptyArray()
    private var index = 0


    init {
        quoteList = loadQuotesFromAssets()
    }

    private fun loadQuotesFromAssets(): Array<QuoteData> {
        return try {
            val inputStream = context.assets.open("quotes.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val json = String(buffer, Charsets.UTF_8)
            val gson = Gson()
            gson.fromJson(json, Array<QuoteData>::class.java)

        } catch (e: Exception) {
            e.printStackTrace()
            emptyArray()
        }

    }
    fun getQuote() = quoteList[index]

    fun nextQuote() = quoteList[++index % quoteList.size]

    fun previousQuote() = quoteList[(--index + quoteList.size) % quoteList.size]
}
