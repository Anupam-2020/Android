package com.example.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdemo.database.SubscriberDAO
import com.example.roomdemo.database.SubscriberDatabase
import com.example.roomdemo.database.SubscriberRepository
import com.example.roomdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: SubscribersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[SubscribersViewModel::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        displayAllSubscribersList()
    }

    private fun displayAllSubscribersList() {
        viewModel.subscribers.observe(this) {
            Log.d("Tag", it.toString())
        }
    }

}