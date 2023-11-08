package com.example.sharedpreferencesdemo

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editName: EditText
    private lateinit var editAge: EditText
    private lateinit var button: Button
    private lateinit var sharedPref: SharedPreferences
    private lateinit var editor: Editor // used to add and edit values for sharedPreferences...

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.edtName)
        editAge= findViewById(R.id.edtNumber)
        button = findViewById(R.id.btnSubmit)
        sharedPref = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sharedPref.edit()

//        button.setOnClickListener {
//            val name = editName.text.toString()
//            val age = editAge.text.toString().toInt()
//            editor.apply {
//                putInt("sf_age", age)
//                putString("sf_name", name)
//                commit()
//            }
//        }
    }

    override fun onPause() {
        super.onPause()
        val name = editName.text.toString()
        val age = editAge.text.toString().toInt()
        editor.apply {
            putString("sf_name", name)
            putInt("sf_age", age)
            commit()
        }
        Log.d("TAG", "on pause called")
    }

    override fun onResume() {
        super.onResume()
        val name = sharedPref.getString("sf_name", null)
        val age = sharedPref.getInt("sf_age", 0)
        editName.setText(name)
        if(age != 0) {
            editAge.setText(age.toString())
        }
    }
}