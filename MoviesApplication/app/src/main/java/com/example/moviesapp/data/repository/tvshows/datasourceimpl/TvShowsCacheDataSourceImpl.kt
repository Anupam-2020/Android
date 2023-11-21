package com.example.moviesapp.data.repository.tvshows.datasourceimpl

import com.example.moviesapp.data.model.tvShowData.TvShow
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsCacheDataSource

class TvShowsCacheDataSourceImpl: TvShowsCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsFromCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}