package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.model.artistData.Artist

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}