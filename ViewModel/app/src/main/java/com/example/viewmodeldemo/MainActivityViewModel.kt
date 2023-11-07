package com.example.viewmodeldemo

import android.util.Log
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private var sum = 0

    fun getSum(): Int {
        return sum
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "Cleared")
    }

    fun updateSum(value: Int) {
        sum+=value
    }
}