package com.example.roomdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.database.Subscriber
import com.example.roomdemo.databinding.ListItemBinding

class SubscriberRecyclerViewAdapter(
    private val context: Context,
    private val clickListener: (Subscriber) -> Unit
): RecyclerView.Adapter<SubscriberViewHolder>() {

    private val subscribersList = ArrayList<Subscriber>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return SubscriberViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        holder.bind(subscribersList[position], clickListener)
    }

    fun setList(subscriber: List<Subscriber>) {
        subscribersList.clear() // clearing older list
        subscribersList.addAll(subscriber) // updating new list.
    }
}


class SubscriberViewHolder(
    private val binding: ListItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit) {
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email
        binding.listItemLayout.setOnClickListener {
            clickListener(subscriber)
        }
    }
}