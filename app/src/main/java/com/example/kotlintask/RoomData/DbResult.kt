package com.example.kotlintask.RoomData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlintask.model.DataModel
import com.example.kotlintask.model.Meals
import com.example.kotlintask.model.Nutrients

@Database(entities = [Meals::class,Nutrients::class], version = 1, exportSchema = false)
abstract class DbResult : RoomDatabase() {

    companion object {
        val DB_NAME = "repoDatabase.db"
        private var instance: DbResult? = null
        fun getInstance(context: Context): DbResult {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    DbResult::class.java,
                    DB_NAME
                ).allowMainThreadQueries().build()
            }
            return instance as DbResult
        }


    }


    abstract fun getRepoDao(): DataBaseDao?

}