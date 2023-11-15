package com.example.roommigration

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EmployeeDAO {

    @Insert
    suspend fun insertEmployee(employee: Employee)

    @Query("SELECT * FROM employee_info")
    fun getAllEmployees(): LiveData<List<Employee>>

    @Query("DELETE FROM employee_info")
    fun deleteAll()
}