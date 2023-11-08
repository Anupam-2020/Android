package com.example.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingSum: Int): ViewModel() {
    private var _sum = MutableLiveData<Int>()
    val sum: LiveData<Int> = _sum

    init {
        _sum.value = startingSum
    }

    fun addToSum(value: Int) {
        _sum.value = _sum.value?.plus(value)
    }

}