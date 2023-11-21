package com.example.moviesapp.presentation.di.core

import com.example.moviesapp.data.repository.artist.ArtistRepositoryImpl
import com.example.moviesapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.moviesapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.moviesapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.moviesapp.data.repository.movies.MoviesRepositoryImpl
import com.example.moviesapp.data.repository.movies.datasource.MovieCacheDataSource
import com.example.moviesapp.data.repository.movies.datasource.MovieLocalDataSource
import com.example.moviesapp.data.repository.movies.datasource.MovieRemoteDataSource
import com.example.moviesapp.data.repository.tvshows.TvShowRepositoryImpl
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsCacheDataSource
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsLocalDataSource
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsRemoteDataSource
import com.example.moviesapp.domain.repository.ArtistRepository
import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository{
        return MoviesRepositoryImpl(
            movieCacheDataSource,
            movieLocalDataSource,
            movieRemoteDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowsRemoteDataSource: TvShowsRemoteDataSource,
        tvShowsLocalDataSource: TvShowsLocalDataSource,
        tvShowsCacheDataSource: TvShowsCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowsRemoteDataSource,
            tvShowsCacheDataSource,
            tvShowsLocalDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}