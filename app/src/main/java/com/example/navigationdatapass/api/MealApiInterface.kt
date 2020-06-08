package com.example.navigationdatapass.api

import com.example.navigationdatapass.model.Meal
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiInterface {
    @GET("filter.php")
    fun getMeal(@Query("c") meal:String):Call<Meal>
}