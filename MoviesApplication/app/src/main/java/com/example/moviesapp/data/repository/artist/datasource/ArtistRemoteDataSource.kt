package com.example.moviesapp.data.repository.artist.datasource

import com.example.moviesapp.data.model.artistData.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {

    suspend fun getArtists(): Response<ArtistList>
}