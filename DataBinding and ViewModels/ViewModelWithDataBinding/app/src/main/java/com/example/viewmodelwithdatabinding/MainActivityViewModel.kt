package com.example.viewmodelwithdatabinding

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private var count = MutableLiveData<Int>()
    val _count: LiveData<Int> = count

    init {
        count.value = 10
    }

    fun updateCount() {
        count.value = count.value?.plus(1)
        Log.d("TAG", count.value.toString())
    }
}