package com.example.viewmodelscope

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers(): List<User> {
        delay(4000)
        val user :List<User> = arrayListOf(
            User(1, "Anupam"),
            User(2, "Anand"),
            User(3, "Virat")
        )
        return user
    }
}