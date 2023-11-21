package com.example.moviesapp.presentation

import android.app.Application
import com.example.moviesapp.BuildConfig
import com.example.moviesapp.presentation.di.Injector
import com.example.moviesapp.presentation.di.artist.ArtistSubComponent
import com.example.moviesapp.presentation.di.core.AppComponent
import com.example.moviesapp.presentation.di.core.AppModule
import com.example.moviesapp.presentation.di.core.DaggerAppComponent
import com.example.moviesapp.presentation.di.core.NetModule
import com.example.moviesapp.presentation.di.core.RemoteDataSourceModule
import com.example.moviesapp.presentation.di.movie.MovieSubComponent
import com.example.moviesapp.presentation.di.tvShow.TvShowSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataSourceModule(RemoteDataSourceModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}