package com.example.moviesapp.presentation.di.movie

import com.example.moviesapp.domain.usecase.GetMoviesUseCase
import com.example.moviesapp.domain.usecase.UpdateMoviesUseCase
import com.example.moviesapp.presentation.movie.MoviesViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MoviesViewModelFactory {
        return MoviesViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}