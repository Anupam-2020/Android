package com.example.moviesapp.presentation.di.core

import com.example.moviesapp.data.api.TMDBService
import com.example.moviesapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.moviesapp.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.moviesapp.data.repository.movies.datasource.MovieRemoteDataSource
import com.example.moviesapp.data.repository.movies.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsRemoteDataSource
import com.example.moviesapp.data.repository.tvshows.datasourceimpl.TvShowsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataSourceModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowsRemoteDataSource {
        return TvShowsRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}