package com.example.roommigration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = EmployeeDatabase.getDatabaseInstance(this).employeeDAO

        val nameEdit = findViewById<EditText>(R.id.name_edt)
        val emailEdt = findViewById<EditText>(R.id.email_edt)
        val button = findViewById<Button>(R.id.add_btn)
        val deleteBtn = findViewById<Button>(R.id.delete)
        button.setOnClickListener {
            lifecycleScope.launch {
                nameEdit.text.let {
                    dao.insertEmployee(Employee(0, it.toString(), emailEdt.text.toString()))
                    nameEdit.setText("")
                    emailEdt.setText("")
                }
            }
        }

        deleteBtn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                dao.deleteAll()
            }
        }
    }
}