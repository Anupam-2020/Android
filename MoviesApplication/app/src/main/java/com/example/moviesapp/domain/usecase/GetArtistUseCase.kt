package com.example.moviesapp.domain.usecase

import com.example.moviesapp.data.model.artistData.Artist
import com.example.moviesapp.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtist()
}