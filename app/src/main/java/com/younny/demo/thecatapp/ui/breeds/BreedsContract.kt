package com.younny.demo.thecatapp.ui.breeds

import com.younny.demo.thecatapp.data.model.Breed

class BreedsContract {
    data class State(
        val breeds: List<Breed>?,
        val isLoading: Boolean = false,
        val error: String? = null
    )
}