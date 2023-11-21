package com.example.moviesapp.presentation.di

import com.example.moviesapp.presentation.di.artist.ArtistSubComponent
import com.example.moviesapp.presentation.di.movie.MovieSubComponent
import com.example.moviesapp.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}