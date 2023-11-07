package com.example.viewmodeldemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        Log.d("TAG", "Created")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

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