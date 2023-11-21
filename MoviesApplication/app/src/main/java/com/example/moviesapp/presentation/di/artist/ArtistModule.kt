package com.example.moviesapp.presentation.di.artist

import com.example.moviesapp.domain.usecase.GetArtistUseCase
import com.example.moviesapp.domain.usecase.UpdateArtistUseCase
import com.example.moviesapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )
    }
}