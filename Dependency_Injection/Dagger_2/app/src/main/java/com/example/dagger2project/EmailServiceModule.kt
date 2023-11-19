package com.example.dagger2project

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class EmailServiceModule {

    @Provides
    fun providesEmailService(): EmailService {
//        Log.d(TAG, "Email sent successfully")
        return EmailService()
    }
}