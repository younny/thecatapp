package com.younny.demo.thecatapp.data.model

import com.google.gson.annotations.SerializedName

data class BreedDetails(
    val id: Int,
    val name: String,
    val weight: String,
    val height: String,
    @SerializedName("life_span")
    val lifeSpan: String,
    @SerializedName("bred_for")
    val bredFor: String,
    @SerializedName("breed_group")
    val breedGroup: String
)
