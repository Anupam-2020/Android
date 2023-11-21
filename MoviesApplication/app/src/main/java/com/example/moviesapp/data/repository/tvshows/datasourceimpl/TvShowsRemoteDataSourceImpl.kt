package com.example.moviesapp.data.repository.tvshows.datasourceimpl

import com.example.moviesapp.data.api.TMDBService
import com.example.moviesapp.data.model.tvShowData.TvShowsList
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsRemoteDataSource
import retrofit2.Response

class TvShowsRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): TvShowsRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowsList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}