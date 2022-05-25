package com.younny.demo.thecatapp.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorOccurred(message: String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(15.dp)
        .wrapContentSize(Alignment.Center)) {
        Column {
            Text(
                text = message
            )
        }
    }
}