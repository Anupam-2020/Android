package com.example.moviesapp.data.repository.artist.datasource

import com.example.moviesapp.data.model.artistData.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsFromDB(artists: List<Artist>)
    suspend fun clearAll()
}