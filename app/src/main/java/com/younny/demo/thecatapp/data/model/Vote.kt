package com.younny.demo.thecatapp.data.model

import com.google.gson.annotations.SerializedName

data class Vote(
    val id: Int,
    @SerializedName("image_id")
    val imageId: String,
    @SerializedName("sub_id")
    val subId: String,
    val value: Int
)
