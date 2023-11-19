package com.example.dagger2project

import dagger.Module
import dagger.Provides

@Module
class EmailServiceModule {

    @Provides
    fun providesEmailService(): EmailService {
        return EmailService()
    }
}