package com.example.moviesapp.data.repository.tvshows.datasource

import com.example.moviesapp.data.model.tvShowData.TvShow

interface TvShowsCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsFromCache(tvShows: List<TvShow>)
}