package com.example.moviesapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.presentation.artist.ArtistsActivity
import com.example.moviesapp.presentation.movie.MoviesActivity
import com.example.moviesapp.presentation.tvShow.TvShowsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.artistBtn.setOnClickListener {
            val intent = Intent(this, ArtistsActivity::class.java)
            startActivity(intent)
        }

        binding.tvShowBtn.setOnClickListener {
            val intent = Intent(this, TvShowsActivity::class.java)
            startActivity(intent)
        }

        binding.moviesBtn.setOnClickListener {
            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
        }
    }
}