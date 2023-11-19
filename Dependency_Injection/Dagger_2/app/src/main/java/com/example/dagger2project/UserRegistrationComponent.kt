package com.example.dagger2project

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    EmailServiceModule::class,
    UserRepositoryModule::class,
    RemoteRepositoryModule::class,
    DatabaseRepositoryModule::class
])
interface UserRegistrationComponent {
//    fun getUserRegistrationComponent(): UserRegistrationService

//    fun getEmailService(): EmailService

    fun getDependency(mainActivity: MainActivity)
}