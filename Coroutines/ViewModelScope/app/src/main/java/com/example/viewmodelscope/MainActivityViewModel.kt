package com.example.viewmodelscope

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel: ViewModel() {
    private var userRepository = UserRepository()

    // M-1 using `live data builder`
    var userData = liveData(Dispatchers.IO) {
        val result = userRepository.getUsers()
        emit(result)
    }

//    M-2 using `traditional method`
//    var userData = MutableLiveData<List<User>?>()

//    private var job = Job()
//    private val myScope = CoroutineScope(Dispatchers.IO + job)


//    M-2 using `traditional method`
//    fun getUserData() {
////        myScope.launch {
////
////        }
//
//        viewModelScope.launch { // We should use viewModelScope instead of normal CoroutineScope because in viewModelScope we don't need to clear the scope manually.
//            var users: List<User>? = null
//            withContext(Dispatchers.IO) {
//                users = userRepository.getUsers()
//            }
//            userData.value = users
//        }
//    }

//    override fun onCleared() {
//        super.onCleared()
//        job.cancel()
//    }
}