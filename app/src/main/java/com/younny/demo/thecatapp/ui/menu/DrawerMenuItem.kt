package com.younny.demo.thecatapp.ui.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.younny.demo.thecatapp.ui.common.BaseRoute

sealed class DrawerMenuItem(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object Cats : DrawerMenuItem(BaseRoute.CatImages.name, Icons.Default.Home, "Cats")
    object Breeds : DrawerMenuItem(BaseRoute.Breeds.name, Icons.Default.Build, "Breeds")
    object Game : DrawerMenuItem(BaseRoute.Game.name, Icons.Default.PlayArrow, "Game")
    object Settings : DrawerMenuItem(BaseRoute.Settings.name, Icons.Default.Settings, "Settings")
}
