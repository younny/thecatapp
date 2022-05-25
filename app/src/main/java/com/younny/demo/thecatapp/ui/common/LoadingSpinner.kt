package com.younny.demo.thecatapp.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.younny.demo.thecatapp.ui.cats.CatsContract
import com.younny.demo.thecatapp.ui.cats.CatsScreen
import com.younny.demo.thecatapp.ui.theme.TheCatAppTheme

@Preview(showBackground = true)
@Composable
fun LoadingSpinner() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().testTag("loadingSpinner")
    ) {
        CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingSpinnerPreview() {
    TheCatAppTheme {
        CatsScreen(CatsContract.State(isLoading = true), null) {}
    }
}