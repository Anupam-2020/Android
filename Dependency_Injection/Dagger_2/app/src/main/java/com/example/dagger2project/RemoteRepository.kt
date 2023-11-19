package com.example.dagger2project

import android.util.Log
import javax.inject.Inject

class RemoteRepository  : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "User saved in remote repo")
    }

}