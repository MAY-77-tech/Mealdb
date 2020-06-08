package com.example.navigationdatapass.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdatapass.R
import com.example.navigationdatapass.model.MealX
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_meal.view.*

class MealAdapter (var mealList: List<MealX> = emptyList()):
        RecyclerView.Adapter<MealAdapter.MealViewModel>(){
    inner class MealViewModel (item: View): RecyclerView.ViewHolder(item){
        fun bind(mealX: MealX) {
            itemView.strmeal.text = mealX.strMeal
            Picasso.get().load(mealX.strMealThumb).placeholder(R.drawable.post).into(itemView.strmealThumb)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewModel {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_meal,parent,false)
        return MealViewModel(view)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onBindViewHolder(holder: MealViewModel, position: Int) {
        holder.bind(mealList[position])
    }

    fun upDateList(mealList: List<MealX>) {
        this.mealList = mealList
        notifyDataSetChanged()
    }
}