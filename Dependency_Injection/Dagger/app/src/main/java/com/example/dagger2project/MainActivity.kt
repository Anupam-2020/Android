package com.example.dagger2project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSmartPhoneComponent.create()
            .getSmartPhone()// This will inject a SmartPhone instance........
            .getCameraActivated() // With the help of above instance we call the smartPhone class methods/variables.......

//        val smartPhone = SmartPhone(
//            Battery(),
//            SimCard(ServiceProvider()),
//            MemoryCard())
//
//        smartPhone.getCameraActivated()
    }
}