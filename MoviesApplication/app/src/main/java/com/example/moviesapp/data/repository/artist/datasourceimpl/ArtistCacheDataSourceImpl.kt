package com.example.moviesapp.data.repository.artist.datasourceimpl

import com.example.moviesapp.data.model.artistData.Artist
import com.example.moviesapp.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artists: ArrayList<Artist> = ArrayList()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artists
    }

    override suspend fun saveArtistFromCache(artists: List<Artist>) {
        this.artists.clear()
        this.artists = ArrayList(artists)
    }
}