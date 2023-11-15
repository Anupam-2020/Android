package com.example.roommigration

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Employee::class],
    version = 1,
    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
abstract class EmployeeDatabase: RoomDatabase() {

    abstract val employeeDAO: EmployeeDAO

    companion object {
        @Volatile
        private var INSTANCE: EmployeeDatabase? = null
        fun getDatabaseInstance(context: Context): EmployeeDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        EmployeeDatabase::class.java,
                        "employee_data_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}