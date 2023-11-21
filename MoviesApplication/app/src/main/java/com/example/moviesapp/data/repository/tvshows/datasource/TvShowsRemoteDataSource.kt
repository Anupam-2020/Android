package com.example.moviesapp.data.repository.tvshows.datasource


import com.example.moviesapp.data.model.tvShowData.TvShowsList
import retrofit2.Response

interface TvShowsRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowsList>
}