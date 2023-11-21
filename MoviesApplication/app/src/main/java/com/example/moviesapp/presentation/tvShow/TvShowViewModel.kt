package com.example.moviesapp.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapp.domain.usecase.GetTvShowsUseCase
import com.example.moviesapp.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {

    fun getTvShows() = liveData {
        emit(getTvShowsUseCase.execute())
    }

    fun updateTvShows() = liveData {
        emit(updateTvShowsUseCase.execute())
    }
}