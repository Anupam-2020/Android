package com.example.moviesapp.data.repository.artist

import android.util.Log
import com.example.moviesapp.data.model.artistData.Artist
import com.example.moviesapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.moviesapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.moviesapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.moviesapp.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsFromDB(newListOfArtists)
        artistCacheDataSource.saveArtistFromCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body != null) {
                artistList = body.artists
            }
        } catch (error: Exception) {
            Log.d("Tag", "Exception from artist repository from Api: $error")
        }

        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()
        } catch (error: Exception) {
            Log.d("Tag", "Exception from artist repository from Cache: $error")
        }

        if(artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistFromCache(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (error: Exception) {
            Log.d("Tag", "Exception from artist repository from Database: $error")
        }
        if(artistList.isEmpty()) {
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistsFromDB(artistList)
            return artistList
        }
        return artistList
    }
}