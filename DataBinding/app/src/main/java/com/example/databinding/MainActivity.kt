package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // After enabling dataBinding in module level gradle file....Step - 1 for adding data-binding.
    var flag: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // Step - 2 -> initializing dataBinding. (DataBindingUtil.setContentView) is by default added, we need to add it to kt file.
        binding.student = getStudent()

//        binding.apply {
//            nameTxt.text = student.name
//            emailTxt.text = student.email
//        }

        binding.submit.setOnClickListener {
            displayGreeting()
            showProgressBar()
        }
    }

    private fun displayGreeting() {
        binding.apply {
            text.text = name.text
        }
    }

    private fun showProgressBar() {
        binding.apply {
            barProgress.visibility = if(flag == 0) View.GONE else View.VISIBLE
            flag = if(flag == 1) 0 else 1
        }
    }

    private  fun getStudent(): Student {
        return Student("Anupam", 1, "anupam@gmail.com")
    }
}