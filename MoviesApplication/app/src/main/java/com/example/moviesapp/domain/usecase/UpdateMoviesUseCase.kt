package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.model.movieData.Movie
import com.example.moviesapp.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}