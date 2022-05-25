package com.younny.demo.thecatapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_table")
data class CatImage(
    @PrimaryKey
    val id: String,
    val url: String,
    val breeds: List<Breed>,
    val categories: List<Category>
)
