package com.younny.demo.thecatapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_image_details_table")
data class CatImageDetails(
    @PrimaryKey
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)