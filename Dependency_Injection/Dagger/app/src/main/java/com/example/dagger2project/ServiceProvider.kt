package com.example.dagger2project

import android.util.Log
import javax.inject.Inject

class ServiceProvider @Inject constructor() {
    init {
        Log.d("Tag", "Service provider constructed")
    }
}
