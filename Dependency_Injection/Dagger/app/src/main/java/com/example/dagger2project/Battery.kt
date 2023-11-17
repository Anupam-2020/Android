package com.example.dagger2project

import android.util.Log
import javax.inject.Inject

class Battery @Inject constructor() {
    init {
        Log.d("Tag", "Battery activated")
    }
}
