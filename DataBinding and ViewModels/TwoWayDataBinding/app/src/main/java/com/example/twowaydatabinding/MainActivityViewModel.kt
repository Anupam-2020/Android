package com.example.twowaydatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private var _sum = MutableLiveData<Int>()
    val sum: LiveData<Int> = _sum

    val inputText = MutableLiveData<String>()

    init {
        _sum.value = 0
    }

    fun setTotal() {
        val intInput: Int? = inputText.value?.toInt()
        _sum.value = intInput?.let {
            _sum.value?.plus(it)
        }
    }
}