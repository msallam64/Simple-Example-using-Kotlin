package com.example.kotlintask.Model

import com.google.gson.annotations.SerializedName


data class DataModel (

    @SerializedName("meals") val meals : List<Meals>,
    @SerializedName("nutrients") val nutrients : Nutrients
)