package com.example.moviesapp.presentation.di.tvShow

import com.example.moviesapp.domain.usecase.GetTvShowsUseCase
import com.example.moviesapp.domain.usecase.UpdateTvShowsUseCase
import com.example.moviesapp.presentation.tvShow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}