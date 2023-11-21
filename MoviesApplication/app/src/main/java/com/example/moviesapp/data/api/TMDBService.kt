package com.example.moviesapp.data.api

import com.example.moviesapp.data.model.artistData.ArtistList
import com.example.moviesapp.data.model.movieData.MovieList
import com.example.moviesapp.data.model.tvShowData.TvShowsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey: String): Response<MovieList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key")apiKey: String): Response<ArtistList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")apiKey: String): Response<TvShowsList>
}