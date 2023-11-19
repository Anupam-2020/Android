package com.example.dagger2project

import dagger.Component

@Component(modules = [EmailServiceModule::class, UserRepositoryModule::class, RemoteRepositoryModule::class])
interface UserRegistrationComponent {
//    fun getUserRegistrationComponent(): UserRegistrationService

//    fun getEmailService(): EmailService

    fun getDependency(mainActivity: MainActivity)
}