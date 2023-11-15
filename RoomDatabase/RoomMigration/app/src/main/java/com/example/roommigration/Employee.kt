package com.example.roommigration

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee_info")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "employee_id")
    val id: Int,

    @ColumnInfo(name = "employee_name")
    var name: String,

    @ColumnInfo(name = "employee_email", defaultValue = "No Email")
    var email: String
)
