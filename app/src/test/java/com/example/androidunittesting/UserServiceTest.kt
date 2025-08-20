package com.example.androidunittesting

import com.example.androidunittesting.mock.LOGIN_STATUS
import com.example.androidunittesting.mock.UserRepository
import com.example.androidunittesting.mock.UserService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyString(), anyString()))
            .thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @Test
    fun testUserService() {

        val sut = UserService(userRepository)
        val status = sut.loginUser("man.1209njnj@gmail.com","123gnjbb")
        Assert.assertEquals("Password is InValid",status)
    }
}