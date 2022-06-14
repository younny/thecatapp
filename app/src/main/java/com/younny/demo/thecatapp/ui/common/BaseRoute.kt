package com.younny.demo.thecatapp.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

enum class BaseRoute(val icon: ImageVector) {
    CatImages(
        icon = Icons.Filled.Face
    ),
    CatDetails(
        icon = Icons.Filled.ThumbUp
    ),
    Breeds(
        icon = Icons.Filled.Build
    ),
    Game(
        icon = Icons.Filled.PlayArrow
    ),
    Settings(
        icon = Icons.Filled.Settings
    );

    companion object {
        fun fromRoute(route: String?): BaseRoute =
            when (route?.substringBefore("/")) {
                CatImages.name -> CatImages
                CatDetails.name -> CatDetails
                Breeds.name -> Breeds
                Game.name -> Game
                Settings.name -> Settings
                null -> CatImages
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}