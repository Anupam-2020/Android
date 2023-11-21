package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.model.artistData.Artist
import com.example.moviesapp.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? {
        return artistRepository.updateArtist()
    }
}