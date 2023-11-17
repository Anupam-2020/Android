package com.example.dagger2project

import android.util.Log
import javax.inject.Inject

class SimCard @Inject constructor(serviceProvider: ServiceProvider) {
    init {
        Log.d("Tag", "SimCard constructed")
    }
}
