package com.example.diintroduction

import android.util.Log

class ServiceProvider {
    init {
        Log.d("Tag", "Service provider constructed")
    }

    fun getServiceProvider() {
        Log.d("Tag", "Service provider connected")
    }
}