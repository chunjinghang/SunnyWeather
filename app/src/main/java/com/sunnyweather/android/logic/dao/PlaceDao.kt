package com.sunnyweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.Place

object PlaceDao {

    //Place对象存储到sharedPreferences文件中
    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place)) //将Place对象转换成一个JSON字符串
        }
    }

    //读取数据
    fun getSavedPlace():Place {
        val placeJson = sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson,Place::class.java)
    }

    //判断是否有数据已被存储
    fun  isPlaceSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() =
        SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}