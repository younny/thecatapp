package com.younny.demo.thecatapp.ui.cats

import com.younny.demo.thecatapp.data.model.CatImage

class CatsContract {
    data class State(
        val catImages: List<CatImage> = listOf(),
        val isLoading: Boolean = false
    )

    sealed class Effect {
        object Loaded : Effect()
    }
}