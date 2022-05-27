package com.younny.demo.thecatapp.ui.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsScreen() {
    Box {
        Text(text = "Settings Screen")
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}