package com.example.moviesapp.data.repository.movies

import android.util.Log
import com.example.moviesapp.data.model.movieData.Movie
import com.example.moviesapp.data.repository.movies.datasource.MovieCacheDataSource
import com.example.moviesapp.data.repository.movies.datasource.MovieLocalDataSource
import com.example.moviesapp.data.repository.movies.datasource.MovieRemoteDataSource
import com.example.moviesapp.domain.repository.MovieRepository

class MoviesRepositoryImpl(
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
): MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieFromDB(newListOfMovies)
        movieCacheDataSource.saveMovieFromCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.d("Tag", "exception message from remote: $e")
        }
        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMovieFromDB()
        } catch (error: Exception) {
            Log.d("Tag", "exception message from room: $error")
        }

        if(movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMovieFromDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (error: Exception) {
            Log.d("Tag", "exception message from cache: $movieList")
        }

        if(movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovieFromCache(movieList)
        }
        return movieList
    }
}