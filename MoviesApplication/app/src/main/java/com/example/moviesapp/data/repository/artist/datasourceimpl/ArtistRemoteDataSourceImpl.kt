package com.example.moviesapp.data.repository.artist.datasourceimpl

import com.example.moviesapp.data.api.TMDBService
import com.example.moviesapp.data.model.artistData.ArtistList
import com.example.moviesapp.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}