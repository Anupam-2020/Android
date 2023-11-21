package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.model.tvShowData.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?
}