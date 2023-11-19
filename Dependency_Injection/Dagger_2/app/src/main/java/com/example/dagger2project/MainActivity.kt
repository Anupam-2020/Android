package com.example.dagger2project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var userRegistrationService: UserRegistrationService

    @Inject lateinit var remoteRepository: RemoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Manual dependency injection
//        val userRegistrationService = UserRegistrationService(UserRepository(), EmailService())
//        userRegistrationService.registerUser("anupamanand.696@gmail.com", "234534tgr")


        // dagger dependency injection M-1....................................................
//        DaggerUserRegistrationComponent.builder().build() // builder is used when there is state with Module-class involved.
//             .getUserRegistrationComponent().registerUser("anupam@gmail.com", "f43644gr")
//
//        DaggerUserRegistrationComponent.create() // create is used when there is no state with Module-class involved.
//            .getEmailService().send("anupam@gmail.com", "anupamanand@gmail.com", "Email sent")

        // dagger dependency injection M-2....................................................
//        DaggerUserRegistrationComponent.create().getDependency(this)
//        DaggerUserRegistrationComponent.builder().remoteRepositoryModule(RemoteRepositoryModule(2000))
//            .build()
//            .getDependency(this)
//        userRegistrationService.registerUser("anupam1@gmail.com", "f43644gr")

//        remoteRepository.saveUser("anurag@gmail.com", "124433rg")


        // For application class.
        (application as UserRegistrationApplication).userRegistrationComponent
            .getDependency(this)
//        remoteRepository.saveUser("anupamanand@gmail.com", "32424tgvfsv")
        userRegistrationService.registerUser("anupam@gmail.com", "afewt42")
    }
}