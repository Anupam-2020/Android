package com.example.dagger2project

import dagger.Module
import dagger.Provides

@Module
class DatabaseRepositoryModule {

    @Provides
    fun provideDatabaseRepo(): DatabaseRepository {
        return DatabaseRepository()
    }
}