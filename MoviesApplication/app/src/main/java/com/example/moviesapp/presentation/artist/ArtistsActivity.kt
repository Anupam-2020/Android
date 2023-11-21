package com.example.moviesapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityArtistsBinding
import com.example.moviesapp.databinding.ActivityTvShowsBinding

class ArtistsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_artists)
    }
}