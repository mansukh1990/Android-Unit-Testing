package com.example.androidunittesting.utils

class Utils {

    fun validatePassword(input: String) = when {
        input.isBlank() -> {
            "Password is required field"
        }

        input.length < 6 -> {
            "Length of the password is greater than 6"
        }

        input.length > 15 -> {
            "Length of the password is less than 15"
        }

        else -> {
            "Valid"
        }
    }

    fun reverseString(input: String?): String {

        if (input ==null){
            throw IllegalArgumentException("Input String is required")
        }

        val chars = input.toCharArray()
        var i = 0
        var j = chars.size - 1

        while (i < j) {
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--

        }
        return chars.joinToString("")

    }
}