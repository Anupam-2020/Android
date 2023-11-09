package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

data class StudentName(val name: String)


class ActivityRecyclerAdapter(
    private val context: Context,
    private val studentName: ArrayList<StudentName>,
    private val clickListener: (student: StudentName) -> Unit
): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemList = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemList)
    }

    override fun getItemCount(): Int {
        return studentName.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.myTextView.text = studentName[position].name
        holder.bind(studentName[position], clickListener)
//        holder.myTextView.text = "Hello from my view holder $position"
    }
}

class MyViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    fun bind(student: StudentName, clickListener: (student: StudentName) -> Unit) {
        val myTextView = view.findViewById<TextView>(R.id.text)
        myTextView.text = student.name

        view.setOnClickListener{
            clickListener(student)
        }
    }
}