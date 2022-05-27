package com.younny.demo.thecatapp.ui.breeds

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BreedsScreen(
    state: BreedsContract.State
) {
    Box() {
        Text(text = "Breeds Screen")
    }
}

@Preview
@Composable
fun CatDetailsCardPreview() {
    BreedsScreen(state = BreedsContract.State(listOf(), false, null))
}
