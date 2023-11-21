package com.example.moviesapp.presentation.di.core

import com.example.moviesapp.domain.repository.ArtistRepository
import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.repository.TvShowRepository
import com.example.moviesapp.domain.usecase.GetArtistUseCase
import com.example.moviesapp.domain.usecase.GetMoviesUseCase
import com.example.moviesapp.domain.usecase.GetTvShowsUseCase
import com.example.moviesapp.domain.usecase.UpdateArtistUseCase
import com.example.moviesapp.domain.usecase.UpdateMoviesUseCase
import com.example.moviesapp.domain.usecase.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }
}