package com.younny.demo.thecatapp.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

enum class BaseScreen(val icon: ImageVector) {
    CatImages(
        icon = Icons.Filled.Face
    ),
    CatDetails(
        icon = Icons.Filled.ThumbUp
    );

    companion object {
        fun fromRoute(route: String?): BaseScreen =
            when (route?.substringBefore("/")) {
                CatImages.name -> CatImages
                CatDetails.name -> CatDetails
                null -> CatImages
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}