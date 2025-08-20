package com.example.androidunittesting.mock

class UserService(private val userRepository: UserRepository) {

    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email, password)

        return when (status) {
            LOGIN_STATUS.INVALID_USER -> "User Does Not Exist"
            LOGIN_STATUS.INVALID_PASSWORD -> "Password is InValid"
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown Error Occurred"
            LOGIN_STATUS.SUCCESS -> "Logged in Successfully"
        }

    }


}