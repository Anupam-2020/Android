package com.example.moviesapp.presentation.tvShow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityTvShowsBinding

class TvShowsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_shows)
    }
}