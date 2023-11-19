package com.example.dagger2project

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRegistrationService @Inject constructor(
    private val userRepository : UserRepository,
    private val emailService : EmailService)
{
    init {
        userRepository.saveUser("anupam@gmail.com", "advd")
        emailService.send("anupam2@gmail.com", "anupam@gmail.com", "Initiated")
        Log.d(TAG, "User registration service initialized")
    }

    fun registerUser(email:String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "no-reply@gmail.com", "User Registered")
    }
}