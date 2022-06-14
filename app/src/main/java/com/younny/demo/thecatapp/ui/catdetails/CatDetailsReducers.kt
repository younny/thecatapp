package com.younny.demo.thecatapp.ui.catdetails

import com.younny.demo.thecatapp.data.model.CatImageDetails
import com.younny.demo.thecatapp.data.common.Result

fun Result<CatImageDetails>.reduce(): CatDetailsState {
    return when (this) {
        is Result.Success -> CatDetailsState.ResultCatDetails(data)
        is Result.Error -> CatDetailsState.Exception(exception)
        is Result.Loading -> CatDetailsState.Loading
    }
}