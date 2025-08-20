package com.example.androidunittesting

import com.example.androidunittesting.utils.Utils
import org.junit.Test
import kotlin.test.assertEquals

class StringTest {

    @Test
    fun testStringReversal_EmptyString_expected_EmptyString(){
        val sut = Utils()
        val result = sut.reverseString("")
        assertEquals("",result)
    }

    @Test
    fun testStringReversal_SingleChar_expected_SingleChar(){
        val sut = Utils()
        val result = sut.reverseString("a")

        assertEquals("a",result)
    }
    @Test
    fun testStringReversal_ValidInput_Expected_SameString(){
        val sut = Utils()
        val result = sut.reverseString("Android")
        assertEquals("diordnA",result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversal_NullValue_Expected_Exception(){
        val sut = Utils()
        val result = sut.reverseString(null)

    }
}