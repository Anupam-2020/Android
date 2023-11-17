package com.example.diintroduction

import android.util.Log

class SimCard(private val serviceProvider: ServiceProvider) {
    init {
        Log.d("Tag", "Sim card constructed")
    }

    fun getConnected() {
        serviceProvider.getServiceProvider()
    }
}