package com.example.dagger2project

import android.util.Log
import javax.inject.Inject


class MemoryCard @Inject constructor() {
    init {
        Log.d("Tag", "Memory Card constructed")
    }
}
