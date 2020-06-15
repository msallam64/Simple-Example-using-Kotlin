package com.example.kotlintask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mealsdata")
data class Meals  (

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "imageType")
    val imageType : String,
    @ColumnInfo(name = "title")
    val title : String,
    @ColumnInfo(name = "readyInMinutes")
    val readyInMinutes : Int,
    @ColumnInfo(name = "servings")
    val servings : Int,
    @ColumnInfo(name = "sourceUrl")
    val sourceUrl : String
)