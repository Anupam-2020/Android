package com.example.moviesapp.presentation.di.core

import com.example.moviesapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.moviesapp.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.moviesapp.data.repository.movies.datasource.MovieCacheDataSource
import com.example.moviesapp.data.repository.movies.datasourceimpl.MovieCacheDataSourceImpl
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsCacheDataSource
import com.example.moviesapp.data.repository.tvshows.datasourceimpl.TvShowsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataSourceModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowsCacheDataSource {
        return TvShowsCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}