package com.example.moviesapp.data.repository.tvshows

import android.util.Log
import com.example.moviesapp.data.model.tvShowData.TvShow
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsCacheDataSource
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsLocalDataSource
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsRemoteDataSource
import com.example.moviesapp.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowsRemoteDataSource: TvShowsRemoteDataSource,
    private val tvShowsCacheDataSource: TvShowsCacheDataSource,
    private val tvShowsLocalDataSource: TvShowsLocalDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowsLocalDataSource.clearAll()
        tvShowsLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowsCacheDataSource.saveTvShowsFromCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response = tvShowsRemoteDataSource.getTvShows()
            val body = response.body()
            if(body != null) {
                tvShowList = body.tvShows
            }
        } catch (e: Exception) {
            Log.d("Tag", "exception message from remote: $e")
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowsLocalDataSource.getTvShowsFromDB()
        } catch (e: Exception) {
            Log.d("Tag", "exception message from DB: $e")
        }
        if(tvShowList.isEmpty()) {
            tvShowList = getTvShowsFromApi()
            tvShowsLocalDataSource.saveTvShowsToDB(tvShowList)
            return tvShowList
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowsCacheDataSource.getTvShowsFromCache()
        } catch (e: Exception) {
            Log.d("Tag", "exception message from cache: $e")
        }
        if(tvShowList.isEmpty()) {
            tvShowList = getTvShowFromDB()
            tvShowsCacheDataSource.saveTvShowsFromCache(tvShowList)
            return tvShowList
        }
        return tvShowList
    }
}