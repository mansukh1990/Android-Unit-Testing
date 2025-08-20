package com.example.androidunittesting.mock

class UserRepository {

    val users = listOf(
        User(1, "Mansukh", "mrm.ec08122@gmail.com", "Mano12345"),
        User(2, "Haresh", "hm.hm08122@gmail.com", "Hare12345"),
        User(3, "Jitesh", "jt.ji08122@gmail.com", "Jitesh12345"),
    )

    fun loginUser(email: String, password: String): LOGIN_STATUS {
        //fetch user from DB

        val users = users.filter { user -> user.email == email }
        return if (users.size == 1) {
            if (users[0].password == password) {
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }
}