package com.example.viewmodeldemo

import android.util.Log
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int): ViewModel() {
    private var sum = 0

    init {
        sum = startingTotal
    }

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