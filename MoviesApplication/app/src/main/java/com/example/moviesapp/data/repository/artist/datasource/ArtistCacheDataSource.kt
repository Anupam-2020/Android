package com.example.moviesapp.data.repository.artist.datasource

import com.example.moviesapp.data.model.artistData.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistFromCache(artists: List<Artist>)
}