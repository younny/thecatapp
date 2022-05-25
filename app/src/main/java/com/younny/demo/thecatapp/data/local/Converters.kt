package com.younny.demo.thecatapp.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.younny.demo.thecatapp.data.model.Breed
import com.younny.demo.thecatapp.data.model.Category
import java.lang.StringBuilder

class Converters {

    @TypeConverter
    fun fromBreeds(breeds: List<Breed>?): String {
        val result = StringBuilder()
        breeds?.forEach {
            result.append(Gson().toJson(it))
            result.append(",")
        }
        return result.toString()
    }

    @TypeConverter
    fun toBreeds(breed: String): List<Breed> {
        return breed.split(Regex(",")).map {
            Gson().fromJson(it, Breed::class.java)
        }
    }

    @TypeConverter
    fun fromCategories(categories: List<Category>?): String {
        val result = StringBuilder()
        categories?.forEach {
            result.append(Gson().toJson(it))
            result.append(",")
        }
        return result.toString()
    }

    @TypeConverter
    fun toCategories(categories: String): List<Category> {
        return categories.split(Regex(",")).map {
            Gson().fromJson(it, Category::class.java)
        }
    }
}