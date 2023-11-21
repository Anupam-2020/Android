package com.example.moviesapp.data.repository.movies.datasource

import com.example.moviesapp.data.model.movieData.Movie

interface MovieLocalDataSource {
    suspend fun getMovieFromDB(): List<Movie>
    suspend fun saveMovieFromDB(movies: List<Movie>)
    suspend fun clearAll()
}