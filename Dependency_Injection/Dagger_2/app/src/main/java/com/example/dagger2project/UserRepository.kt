package com.example.dagger2project

import android.util.Log
import javax.inject.Inject

interface UserRepository{
    fun saveUser(email:String, password: String)
}