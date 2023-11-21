package com.example.moviesapp.data.repository.movies.datasourceimpl

import com.example.moviesapp.data.model.movieData.Movie
import com.example.moviesapp.data.repository.movies.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieFromCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}