package com.example.moviesapp.data.repository.movies.datasourceimpl

import com.example.moviesapp.data.api.TMDBService
import com.example.moviesapp.data.model.movieData.MovieList
import com.example.moviesapp.data.repository.movies.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}