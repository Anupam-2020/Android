package com.example.viewmodeldemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.databinding.ActivityMainBinding

//Note:- Added lifecycle methods to understand the relation of view-model's life-cycle with activity's life-cycle...

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory // for custom view-model...

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        Log.d("TAG", "Created")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(100) // initializing custom view-model with value...
        viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java] // viewModelProvider has an optional argument which is coming from customViewModel class...

        binding.sum.text = viewModel.getSum().toString()
        binding.incrementBtn.setOnClickListener {
            val value = binding.addNumber.text.toString().toInt()
            viewModel.updateSum(value)
            binding.sum.text = viewModel.getSum().toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "Started")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "Paused")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG", "Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "Destroyed")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "Resume")
    }
}