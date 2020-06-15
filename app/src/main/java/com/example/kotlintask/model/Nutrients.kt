package com.example.kotlintask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "nutrientdata")
data class Nutrients(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "calories")
    val calories: Double,

    @ColumnInfo(name = "protein")
    val protein: Double,

    @ColumnInfo(name = "fat")
    val fat: Double,

    @ColumnInfo(name = "carbohydrates")
    val carbohydrates: Double
)