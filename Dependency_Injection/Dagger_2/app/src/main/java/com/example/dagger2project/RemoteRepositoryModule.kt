package com.example.dagger2project

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class RemoteRepositoryModule(val memorySize: Int) {

    @Provides
    fun provideRemoteRepository(): RemoteRepository {
        Log.d(TAG,"Size of memory is $memorySize")
        return RemoteRepository()
    }
}