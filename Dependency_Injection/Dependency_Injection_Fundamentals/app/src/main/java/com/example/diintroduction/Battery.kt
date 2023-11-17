package com.example.diintroduction

import android.util.Log

class Battery {
    init {
        Log.d("Tag", "Battery constructor created")
    }

    fun getBatteryStatus() {
        Log.d("Tag", "Battery accessed")
    }
}