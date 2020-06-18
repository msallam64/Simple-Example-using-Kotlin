package com.example.kotlintask.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintask.Networking.BASE_IMAGE_SIZE
import com.example.kotlintask.Networking.BASE_IMAGE_URL
import com.example.kotlintask.R
import com.example.kotlintask.model.Meals
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.meals_item.view.*


class adapter(private val mMeals: List<Meals>) : RecyclerView.Adapter<adapter.ViewHolder>() {


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title = itemView.title_tv
        val imageView = itemView.title_iv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meals_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mMeals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mealTitle = mMeals.get(position).title
        val mealID = mMeals.get(position)
        holder.title?.text = mealTitle
        Picasso.get().load(BASE_IMAGE_URL + mealID + BASE_IMAGE_SIZE)
            .into(holder.imageView)


    }
}
