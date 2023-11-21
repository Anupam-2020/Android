package com.example.moviesapp.data.repository.movies.datasourceimpl

import com.example.moviesapp.data.dao.MovieDao
import com.example.moviesapp.data.model.movieData.Movie
import com.example.moviesapp.data.repository.movies.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMovieFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMovieFromDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}