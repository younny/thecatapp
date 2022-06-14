package com.younny.demo.thecatapp.ui.cats

import com.younny.demo.thecatapp.data.common.CallErrors
import com.younny.demo.thecatapp.data.model.CatImage
import com.younny.demo.thecatapp.ui.common.ViewState

sealed class CatsState : ViewState {
    object Loading : CatsState()
    data class ResultAllCatImages(val data : List<CatImage>): CatsState()
    data class Exception(val callErrors: CallErrors): CatsState()
}
