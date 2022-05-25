package com.younny.demo.thecatapp.ui.menu

import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TopMenuBar(navigationIcon: @Composable (() -> Unit)?) {
    TopAppBar(
        title = { Text("The Cat App") },
        contentColor = Color.White,
        navigationIcon = navigationIcon,
        actions = {

        },
        elevation = AppBarDefaults.TopAppBarElevation
    )
}