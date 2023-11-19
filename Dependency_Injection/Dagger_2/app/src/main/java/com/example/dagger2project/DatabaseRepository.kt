package com.example.dagger2project

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


class DatabaseRepository: UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User saved to database")
    }
}