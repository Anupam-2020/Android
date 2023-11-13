package com.example.coroutines

import android.util.Log
import kotlinx.coroutines.delay

class AsyncAwait {
    suspend fun getStockCount1(): Int {
        delay(10000)
        Log.d("Tag", "stock1 Started")
        return 40000
    }

    suspend fun getStockCount2(): Int {
        delay(7000)
        Log.d("Tag", "Stock2 started")
        return 50000
    }
}