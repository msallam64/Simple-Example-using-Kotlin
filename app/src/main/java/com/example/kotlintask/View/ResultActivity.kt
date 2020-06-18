package com.example.kotlintask.View

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintask.Adapter.adapter
import com.example.kotlintask.R
import com.example.kotlintask.RoomData.DbResult
import com.example.kotlintask.model.Meals
import com.example.kotlintask.model.Nutrients

class ResultActivity : AppCompatActivity() {

    var dataDb: DbResult? = null
    var roomdataMeals: List<Meals>? = null
    var roomdataNutrient: Nutrients? = null
    private var list: RecyclerView? = null
    private var recyclerAdapter: adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        list = findViewById(R.id.list_iv)
        var calories: TextView = findViewById(R.id.calories_tv)
        var protein: TextView = findViewById(R.id.protein_tv)
        var fat: TextView = findViewById(R.id.fat_tv)
        var carbohydrates: TextView = findViewById(R.id.carbohy_tv)

        dataDb = DbResult.getInstance(getApplication())
        roomdataMeals = dataDb!!.getRepoDao()?.getAllmeals()!!
        val layoutManager = LinearLayoutManager(this)
        list!!.setLayoutManager(layoutManager)
        recyclerAdapter = adapter(roomdataMeals!!)
        list!!.setAdapter(recyclerAdapter)

        roomdataNutrient = dataDb!!.getRepoDao()?.getAllnutrient()
        calories.text = roomdataNutrient!!.calories.toString()
        protein.text = roomdataNutrient!!.protein.toString()
        fat.text = roomdataNutrient!!.fat.toString()
        carbohydrates.text = roomdataNutrient!!.carbohydrates.toString()


    }


}