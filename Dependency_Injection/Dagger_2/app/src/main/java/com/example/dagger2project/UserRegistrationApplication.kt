package com.example.dagger2project

import android.app.Application


// application class is used to create the object of class or implement method which is required at the start of application.
class UserRegistrationApplication: Application() {

    lateinit var userRegistrationComponent: UserRegistrationComponent

    override fun onCreate() {
        super.onCreate()
        userRegistrationComponent = initDagger()
    }

    private fun initDagger(): UserRegistrationComponent =
        DaggerUserRegistrationComponent.builder()
            .remoteRepositoryModule(RemoteRepositoryModule(2000))
            .build()
}