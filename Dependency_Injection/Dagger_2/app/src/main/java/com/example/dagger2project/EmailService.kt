package com.example.dagger2project

import android.util.Log
import javax.inject.Inject

// Consider this class as 3rd party class which can't be annotated with @Inject. We need a module class for this.
class EmailService {
    fun send(to:String, from:String, body: String?) {
        Log.d(TAG, "Email Sent")
    }
}