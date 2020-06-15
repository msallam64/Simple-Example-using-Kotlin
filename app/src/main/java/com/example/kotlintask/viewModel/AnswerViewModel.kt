package com.example.kotlintask.viewModel


import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlintask.Networking.Networking
import com.example.kotlintask.RoomData.DbResult
import com.example.kotlintask.Util.SingleLiveEvent
import com.example.kotlintask.model.*
import com.example.kotlintask.model.Meals
import com.example.kotlintask.model.Nutrients
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnswerViewModel(application: Application) : AndroidViewModel(application),
    Callback<DataModel> {

    var answer1: ObservableField<String>? = null
    var answer2: ObservableField<String>? = null
    var answer3: ObservableField<String>? = null
    var userData: MutableLiveData<DataModel>? = null
    val uiEventLiveData = SingleLiveEvent<Int>()
    var mealsdata: List<Meals>? = null
    var nutrient: Nutrients? = null
    var data: DataModel? = null
    var databaseReslut: DbResult? = null


    init {
        answer1 = ObservableField("")
        answer2 = ObservableField("")
        answer3 = ObservableField("")
        userData = MutableLiveData<DataModel>()
    }

    fun getresult() {
        if (answer1 == null || answer2 == null || answer3 == null) {
        } else {
            var request = Networking.Factory.create()
            val call = request.getMeals(
                "day",
                targetCalories = answer1?.get()!!,
                diet = answer2?.get()!!,
                exclude = answer3?.get()!!
            )
            call.enqueue(this)

        }
    }

    override fun onFailure(call: Call<DataModel>, t: Throwable) {
        Log.e("ER", t.message.toString())
    }

    override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
        if (response.isSuccessful) {
            databaseReslut = DbResult.getInstance(getApplication())
            data = response.body()!!
            mealsdata = data!!.meals
            nutrient = data!!.nutrients
            databaseReslut!!.getRepoDao()!!.insertAllmeals(mealsdata)
            databaseReslut!!.getRepoDao()!!.insertAllnutrient(nutrient)
            uiEventLiveData.value = 1
        }

    }

}