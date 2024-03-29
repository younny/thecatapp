package com.younny.demo.thecatapp.ui.cats

import com.younny.demo.thecatapp.data.common.Result
import com.younny.demo.thecatapp.data.model.CatImage

fun Result<List<CatImage>>.reduce(): CatsState {
    return when (this) {
        is Result.Success -> CatsState.ResultAllCatImages(data)
        is Result.Error -> CatsState.Exception(exception)
        is Result.Loading -> CatsState.Loading
    }
}