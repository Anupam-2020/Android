package com.example.moviesapp.data.repository.tvshows.datasource

import com.example.moviesapp.data.model.tvShowData.TvShow

interface TvShowsLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}