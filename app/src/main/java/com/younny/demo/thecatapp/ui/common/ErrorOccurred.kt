package com.younny.demo.thecatapp.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.younny.demo.thecatapp.data.common.CallErrors

@Composable
fun ErrorOccurred(errors: CallErrors) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(15.dp)
        .wrapContentSize(Alignment.Center)) {
        Column {
            Text(
                text = extractMessage(errors)
            )
        }
    }
}

fun extractMessage(callErrors: CallErrors): String {
    return when (callErrors) {
        is CallErrors.ErrorServer -> "Server Error Occurred."
        is CallErrors.ErrorEmptyData -> "Data is empty."
        is CallErrors.ErrorException -> callErrors.throwable.message.toString()
    }
}