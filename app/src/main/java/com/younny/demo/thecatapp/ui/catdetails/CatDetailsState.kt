package com.younny.demo.thecatapp.ui.catdetails

import com.younny.demo.thecatapp.data.common.CallErrors
import com.younny.demo.thecatapp.data.model.CatImageDetails
import com.younny.demo.thecatapp.ui.common.ViewState

sealed class CatDetailsState : ViewState {
    object Loading : CatDetailsState()
    data class ResultCatDetails(val data: CatImageDetails): CatDetailsState()
    data class Exception(val callErrors: CallErrors) : CatDetailsState()
}