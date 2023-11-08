package com.example.viewmodelwithdatabinding

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var count = MutableLiveData<Int>()

    init {
        count.value = 10
    }

    fun updateCount() {
        count.value = count.value?.plus(1)
        Log.d("TAG", count.value.toString())
    }
}