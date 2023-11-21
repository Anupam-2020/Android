package com.example.moviesapp.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMoviesBinding
import com.example.moviesapp.presentation.di.Injector
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {

    @Inject lateinit var factory: MoviesViewModelFactory
    private lateinit var movieViewModel: MoviesViewModel

    private lateinit var binding: ActivityMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {it ->
            it?.forEach {
               Log.d("Tag", it.toString())
            }
        })
    }
}