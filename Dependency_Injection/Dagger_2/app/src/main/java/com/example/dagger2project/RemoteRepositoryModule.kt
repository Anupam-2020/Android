package com.example.dagger2project

import dagger.Module
import dagger.Provides

@Module
class RemoteRepositoryModule {

    @Provides
    fun provideRemoteRepository(): RemoteRepository {
        return RemoteRepository()
    }
}