package com.example.diintroduction

import android.util.Log

class SmartPhone(memoryCard: MemoryCard) {
    private lateinit var simCard: SimCard

    init {
        Log.d("Tag", "Smart Phone constructed")
    }

    var battery:Battery = Battery() // Field injection

    fun setSimCard(simCard: SimCard) { // method injection
        this.simCard = SimCard(ServiceProvider())
    }

    fun makeCallRecording() {
        Log.d("Tag", "Make call recording")
    }
}