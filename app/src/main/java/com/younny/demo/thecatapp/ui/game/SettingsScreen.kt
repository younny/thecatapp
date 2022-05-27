package com.younny.demo.thecatapp.ui.game

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GameScreen() {
    Box {
        Text(text = "Game Screen")
    }
}

@Preview
@Composable
fun GameScreenPreview() {
    GameScreen()
}