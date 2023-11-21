package com.example.moviesapp.data.repository.tvshows.datasourceimpl

import com.example.moviesapp.data.dao.TvShowDao
import com.example.moviesapp.data.model.tvShowData.TvShow
import com.example.moviesapp.data.repository.tvshows.datasource.TvShowsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowsLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowsLocalDataSource {

    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getAllTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}