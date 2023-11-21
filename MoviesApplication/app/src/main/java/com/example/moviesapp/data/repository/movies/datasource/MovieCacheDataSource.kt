package com.example.moviesapp.data.repository.movies.datasource

import com.example.moviesapp.data.model.movieData.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMovieFromCache(movies: List<Movie>)
}