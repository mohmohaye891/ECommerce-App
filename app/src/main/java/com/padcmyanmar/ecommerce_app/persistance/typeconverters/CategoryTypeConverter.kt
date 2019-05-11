package com.padcmyanmar.ecommerce_app.persistance.typeconverters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.ecommerce_app.data.vos.CategoryVO

class CategoryTypeConverter {
    @TypeConverter
    fun formJsonToList(category: String) : MutableList<CategoryVO> {
        val listType = object : TypeToken<MutableList<CategoryVO>> () {

        }.type
        return Gson().fromJson(category, listType)
    }

    @TypeConverter
    fun fromListToJson(images : MutableList<CategoryVO>) : String {
        return Gson().toJson(images)
    }
}