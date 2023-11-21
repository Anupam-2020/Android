package com.example.moviesapp.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.data.model.artistData.Artist
import com.example.moviesapp.data.model.movieData.Movie
import com.example.moviesapp.data.model.tvShowData.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artisDao(): ArtistDao
}