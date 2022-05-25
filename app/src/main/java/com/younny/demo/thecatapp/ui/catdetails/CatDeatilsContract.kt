package com.younny.demo.thecatapp.ui.catdetails

import com.younny.demo.thecatapp.data.model.CatImageDetails

class CatDetailsContract {
    data class State(
        val details: CatImageDetails?,
        val isLoading: Boolean = false,
        val error: String? = null
    )
}