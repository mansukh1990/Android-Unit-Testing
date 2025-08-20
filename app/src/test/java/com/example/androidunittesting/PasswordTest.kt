package com.example.androidunittesting

import com.example.androidunittesting.utils.Utils
import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordTest {

    @Test
    fun validatePassword_blankInput_expected_requiredField() {
        val sut = Utils()

        val result = sut.validatePassword("    ")
        assertEquals("Password is required field",result)
    }
    @Test
    fun validatePassword_2CharInput_expected_validationMsg(){
        val sut = Utils()

        val result = sut.validatePassword("ab")
        assertEquals("Length of the password is greater than 6",result)
    }
    @Test
    fun validatePassword_CorrectInput_expected_validPassword(){
        val  sut = Utils()

        val  result = sut.validatePassword("mans344")
        assertEquals("Valid",result)
    }
}