package com.example.kotlintask.Networking

import com.example.kotlintask.model.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

//

interface NetworkInterFace {

    @Headers(
        "x-rapidapi-host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
        "x-rapidapi-key: api-key",
        "useQueryString: true"
    )
    @GET("recipes/mealplans/generate")
    fun getMeals(
        @Query("timeFrame") timeFrame: String,@Query("targetCalories") targetCalories: String, @Query("diet") diet: String,
        @Query("exclude") exclude: String
    ): Call<DataModel>
}