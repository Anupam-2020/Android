package com.example.roommigration

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [Employee::class],
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
    AutoMigration(from = 2, to = 3, spec = EmployeeDatabase.MigrateFrom2To3::class),
    AutoMigration(from = 3, to = 4)
    ]
)
abstract class EmployeeDatabase: RoomDatabase() {

    abstract val employeeDAO: EmployeeDAO

    @RenameColumn(tableName = "employee_info", fromColumnName = "employee_email", toColumnName = "emp_email")
    class MigrateFrom2To3: AutoMigrationSpec
    
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