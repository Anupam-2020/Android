package com.example.viewmodelscope

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel: ViewModel() {
    private var userRepository = UserRepository()
    var userData = MutableLiveData<List<User>?>()

//    private var job = Job()
//    private val myScope = CoroutineScope(Dispatchers.IO + job)

    fun getUserData() {
//        myScope.launch {
//
//        }

        viewModelScope.launch { // We should use viewModelScope instead of normal CoroutineScope because in viewModelScope we don't need to clear the scope manually.
            var users: List<User>? = null
            withContext(Dispatchers.IO) {
                users = userRepository.getUsers()
            }
            userData.value = users
        }
    }

//    override fun onCleared() {
//        super.onCleared()
//        job.cancel()
//    }
}