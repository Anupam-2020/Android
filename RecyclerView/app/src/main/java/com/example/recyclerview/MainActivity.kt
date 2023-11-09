package com.example.recyclerview

import android.graphics.Color
import android.graphics.Paint.Style
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var studentList = ArrayList<StudentName>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setBackgroundColor(Color.GREEN)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ActivityRecyclerAdapter(this, studentList) {
            selectedName: StudentName -> onClickListener(selectedName)
        }

        studentList.add(StudentName("Anupam"))
        studentList.add(StudentName("Anand"))
        studentList.add(StudentName("Rahul"))
        studentList.add(StudentName("Sharma"))
    }

    private fun onClickListener(studentName: StudentName) {
        Toast.makeText(this@MainActivity, "Student selected: ${studentName.name}", Toast.LENGTH_SHORT).show()
    }
}