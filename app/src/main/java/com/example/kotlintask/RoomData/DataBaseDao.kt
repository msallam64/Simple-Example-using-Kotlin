package com.example.kotlintask.RoomData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlintask.model.Meals
import com.example.kotlintask.model.Nutrients

@Dao
interface DataBaseDao {
    @Query("SELECT * FROM mealsdata")
    fun getAllmeals(): List<Meals>?

    @Query("SELECT * FROM nutrientdata")
    fun getAllnutrient(): Nutrients?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllmeals(dataMeals: List<Meals>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllnutrient(dataNutrients: Nutrients?)
}