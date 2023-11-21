package com.example.moviesapp.presentation.di.core

import com.example.moviesapp.data.dao.ArtistDao
import com.example.moviesapp.data.dao.MovieDao
import com.example.moviesapp.data.dao.TvShowDao
import com.example.moviesapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.moviesapp.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.moviesapp.data.repository.movies.datasource.MovieLocalDataSource
import com.example.moviesapp.data.repository.movies.datasourceimpl.MovieLocalDataSourceImpl
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsLocalDataSource
import com.example.moviesapp.data.repository.tvshows.datasourceimpl.TvShowsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowsLocalDataSource {
        return TvShowsLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}