package com.example.moviesapp.data.repository.movies.datasource

import com.example.moviesapp.data.model.movieData.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}