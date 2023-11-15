package com.example.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdemo.database.Subscriber
import com.example.roomdemo.database.SubscriberDAO
import com.example.roomdemo.database.SubscriberDatabase
import com.example.roomdemo.database.SubscriberRepository
import com.example.roomdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: SubscribersViewModel
    private lateinit var adapter: SubscriberRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[SubscribersViewModel::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        initRecyclerView()

        viewModel.message.observe(this, Observer {it: Event<String> ->
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun displayAllSubscribersList() {
        viewModel.subscribers.observe(this) {
//            Log.d("Tag", it.toString())
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        binding.subscribersRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SubscriberRecyclerViewAdapter(this) {
            listItemClicked(it)
        }
        binding.subscribersRecyclerView.adapter = adapter
        displayAllSubscribersList()
    }

    private fun listItemClicked(subscriber: Subscriber) {
//        Toast.makeText(this, subscriber.name, Toast.LENGTH_SHORT).show()
        viewModel.initUpdateAndDeleteSubscribers(subscriber)
    }
}