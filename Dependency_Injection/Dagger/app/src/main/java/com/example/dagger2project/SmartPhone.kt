package com.example.dagger2project

import android.util.Log
import javax.inject.Inject

class SmartPhone @Inject constructor(battery: Battery, simCard: SimCard, memoryCard: MemoryCard) {
    init {
        Log.d("Tag", "Smart phone launched")
    }

    fun getCameraActivated() {
        Log.d("Tag", "Camera activated")
    }
}