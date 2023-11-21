package com.example.moviesapp.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapp.domain.usecase.GetArtistUseCase
import com.example.moviesapp.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel() {

    fun getArtists() = liveData {
        emit(getArtistUseCase.execute())
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}