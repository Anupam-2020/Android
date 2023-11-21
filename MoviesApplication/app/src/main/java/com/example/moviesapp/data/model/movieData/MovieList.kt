package com.example.moviesapp.data.model.movieData


import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>,
)