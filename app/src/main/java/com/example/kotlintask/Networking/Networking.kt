package com.example.kotlintask.Networking

import android.util.Log
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Networking {
    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): NetworkInterFace {
            Log.e("retrofit", "created")
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(NetworkInterFace::class.java)
        }
    }



}