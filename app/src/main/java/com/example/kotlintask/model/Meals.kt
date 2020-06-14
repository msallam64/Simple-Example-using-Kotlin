package com.example.kotlintask.model


data class Meals (

    val id : Int,
    val imageType : String,
    val title : String,
    val readyInMinutes : Int,
    val servings : Int,
    val sourceUrl : String
)