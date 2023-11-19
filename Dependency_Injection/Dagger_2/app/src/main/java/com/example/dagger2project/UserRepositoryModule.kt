package com.example.dagger2project

import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
abstract class UserRepositoryModule {

    @Binds
    abstract fun remoteRepository(remoteRepository: RemoteRepository): UserRepository
}