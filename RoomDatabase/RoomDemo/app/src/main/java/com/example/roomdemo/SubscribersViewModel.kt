package com.example.roomdemo

import android.util.Patterns
import androidx.lifecycle.LiveData
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

    private val statusMessage = MutableLiveData<Event<String>>()

    val message: LiveData<Event<String>>
        get() = statusMessage

    init {
        saveOrUpdateButtonText.value = "SAVE"
        clearAllOrDeleteButtonText.value = "CLEAR ALL"
    }

    fun saveOrUpdate() {

        if(inputName.value == null) {
            statusMessage.value = Event("Please enter subscriber's name")
        } else if(inputEmail.value == null) {
            statusMessage.value = Event("Please enter subscriber's email")
        } else if(!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value).matches()) {
            statusMessage.value = Event("Please enter correct email address")
        } else {
            if (isUpdateOrDelete) {
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
    }

    fun clearAllOrDelete() {
        if(isUpdateOrDelete) {
            deleteSubscriber(subscriberToUpdateOrDelete)
        } else {
            deleteAll()
        }
    }

    private fun insertSubscriber(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        val newRowId = repository.insert(subscriber)
        withContext(Dispatchers.Main) {
            if(newRowId > -1) {
                statusMessage.value = Event("Subscriber inserted successfully! $newRowId")
            } else {
                statusMessage.value = Event("Error Occurred!")
            }
        }
    }


    private fun updateSubscriber(subscriber: Subscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            val updatedRows = repository.update(subscriber)
            withContext(Dispatchers.Main) {
                if(updatedRows > 0) {
                    inputName.value = ""
                    inputEmail.value = ""
                    isUpdateOrDelete = false
                    saveOrUpdateButtonText.value = "SAVE"
                    clearAllOrDeleteButtonText.value = "CLEAR ALL"
                    statusMessage.value = Event("$updatedRows Subscriber updated successfully")
                } else {
                    statusMessage.value = Event("Error Occurred!")
                }
            }
        }
    }

    fun deleteSubscriber(subscriber: Subscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            val noOfRowsDeleted = repository.delete(subscriber)
            withContext(Dispatchers.Main){
                if(noOfRowsDeleted > 0) {
                    inputName.value = ""
                    inputEmail.value = ""
                    isUpdateOrDelete = false
                    saveOrUpdateButtonText.value = "SAVE"
                    clearAllOrDeleteButtonText.value = "CLEAR ALL"
                    statusMessage.value = Event("$noOfRowsDeleted Subscriber deleted successfully")
                } else {
                    statusMessage.value = Event("Error Occurred!")
                }
            }
        }
    }

    private fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        val noOfRowsDeleted = repository.deleteAll()
        withContext(Dispatchers.Main) {
            if(noOfRowsDeleted > 0) {
                statusMessage.value = Event("$noOfRowsDeleted subscribers deleted successfully")
            } else {
                statusMessage.value = Event("Error occurred")
            }
        }
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