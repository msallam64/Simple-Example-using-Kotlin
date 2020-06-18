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
    var answer1: ObservableField<String?>? = null
    var answer2: ObservableField<String?>? = null
    var answer3: ObservableField<String?>? = null
    var userData: MutableLiveData<DataModel>? = null
    val uiEventLiveData = SingleLiveEvent<Int>()
    var mealsdata: List<Meals>? = null
    var nutrient: Nutrients? = null
    var data: DataModel? = null
    var databaseReslut: DbResult? = null


    init {
        answer1 = ObservableField<String?>("")
        answer2 = ObservableField<String?>("")
        answer3 = ObservableField<String?>("")
        userData = MutableLiveData<DataModel>()
    }

    fun getresult() {
        val ans1: String? = answer1?.get()?.apply { val value = toString() }
        val ans2: String? = answer2?.get()?.apply { val value = toString() }
        val ans3: String? = answer3?.get()?.apply { val value = toString() }
        if (ans1?.length!! > 0 && ans2?.length!! > 0 && ans3?.length!! > 0) {
            var request = Networking.Factory.create()
            val call = request.getMeals(
                "day",
                targetCalories = ans1!!,
                diet = ans2!!,
                exclude = ans3!!
            )
            call.enqueue(this)
        } else {
            uiEventLiveData.value = 0
        }
    }

    override fun onFailure(call: Call<DataModel>, t: Throwable) {
        Log.e("ER", t.message.toString())
        uiEventLiveData.value = 0
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
        } else {
            uiEventLiveData.value = 0
        }

    }

}