package com.example.roomdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Delete
import com.example.roomdemo.database.Subscriber
import com.example.roomdemo.database.SubscriberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class SubscribersViewModel(private val repository: SubscriberRepository): ViewModel() {

    val subscribers = repository.subscribers
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "SAVE"
        clearAllOrDeleteButtonText.value = "CLEAR ALL"
    }

    fun saveOrUpdate() {
        if(isUpdateOrDelete) {
            subscriberToUpdateOrDelete.name = inputName.value.toString()
            subscriberToUpdateOrDelete.email = inputEmail.value.toString()
            updateSubscriber(subscriberToUpdateOrDelete)
        } else {
            val name = inputName.value
            val email = inputEmail.value
            insertSubscriber(Subscriber(0, name.toString(), email.toString()))
            inputName.value = ""
            inputEmail.value = ""
        }
    }

    fun clearAllOrDelete() {
        if(isUpdateOrDelete) {
            deleteSubscriber(subscriberToUpdateOrDelete)
        } else {
            deleteAll()
        }
    }

    fun insertSubscriber(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
            repository.insert(subscriber)
        }


    fun updateSubscriber(subscriber: Subscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(subscriber)
            withContext(Dispatchers.Main) {
                inputName.value = ""
                inputEmail.value = ""
                isUpdateOrDelete = false
                saveOrUpdateButtonText.value = "SAVE"
                clearAllOrDeleteButtonText.value = "CLEAR ALL"
            }
        }
    }

    fun deleteSubscriber(subscriber: Subscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(subscriber)
            withContext(Dispatchers.Main){
                inputName.value = ""
                inputEmail.value = ""
                isUpdateOrDelete = false
                saveOrUpdateButtonText.value = "SAVE"
                clearAllOrDeleteButtonText.value = "CLEAR ALL"
            }
        }
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }

    fun initUpdateAndDeleteSubscribers(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateButtonText.value = "UPDATE"
        clearAllOrDeleteButtonText.value = "DELETE"
    }
}