package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.model.tvShowData.TvShow
import com.example.moviesapp.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? {
        return tvShowRepository.getTvShows()
    }
}