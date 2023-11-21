package com.example.moviesapp.presentation.di.tvShow

import com.example.moviesapp.presentation.tvShow.TvShowsActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowsActivity: TvShowsActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}