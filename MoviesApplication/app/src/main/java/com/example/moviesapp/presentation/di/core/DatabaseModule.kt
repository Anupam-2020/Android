package com.example.moviesapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.data.dao.ArtistDao
import com.example.moviesapp.data.dao.MovieDao
import com.example.moviesapp.data.dao.TMDBDatabase
import com.example.moviesapp.data.dao.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideTMDBDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            "tmdbclient"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artisDao()
    }
}