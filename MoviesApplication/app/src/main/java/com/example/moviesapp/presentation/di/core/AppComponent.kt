package com.example.moviesapp.presentation.di.core

import com.example.moviesapp.presentation.di.artist.ArtistSubComponent
import com.example.moviesapp.presentation.di.movie.MovieSubComponent
import com.example.moviesapp.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataSourceModule::class,
    DatabaseModule::class,
    NetModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataSourceModule::class,
    LocalDataSourceModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}