package com.example.moviesapp.data.model.tvShowData


import com.google.gson.annotations.SerializedName

data class TvShowsList(
    @SerializedName("results")
    val tvShows: List<TvShow>,
)