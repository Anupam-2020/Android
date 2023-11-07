package com.example.livedatademo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class MainActivityViewModelFactory(private val startingSum: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(startingSum) as T
        }
        throw IllegalArgumentException("Unknown class view model")
    }


}