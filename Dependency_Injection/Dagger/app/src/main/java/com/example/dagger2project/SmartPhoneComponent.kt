package com.example.dagger2project

import dagger.Component

@Component
interface SmartPhoneComponent {

    fun getSmartPhone(): SmartPhone
}