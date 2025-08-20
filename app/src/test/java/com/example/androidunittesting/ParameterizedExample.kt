package com.example.androidunittesting

import com.example.androidunittesting.utils.Helper
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedExample(
    private val input: String, private val expectedValue: Boolean
) {
    @Test
    fun test() {
        val helper = Helper()
        val result = helper.isPallindrome(input)
        assertEquals(expectedValue, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}:{0} is pallindrone - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }
}