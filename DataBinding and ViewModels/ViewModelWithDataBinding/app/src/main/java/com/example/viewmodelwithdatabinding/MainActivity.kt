package com.example.viewmodelwithdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelwithdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModels: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModels = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.viewModel = viewModels // connecting binding-viewModel with ActivityViewModel-class...
        binding.lifecycleOwner = this // this is for connecting live data with data-binding...

//        viewModels._count.observe(this, Observer {
//          binding.countTxt.text = it.toString()
//        })
    }
}