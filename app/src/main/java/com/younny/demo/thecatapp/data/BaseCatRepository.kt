package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.model.CatImage
import com.younny.demo.thecatapp.data.model.CatImageDetails
import com.younny.demo.thecatapp.data.common.Result
import kotlinx.coroutines.flow.Flow

interface BaseCatRepository {
    val catImages: Flow<Result<List<CatImage>>>
    fun catImageDetails(imageId: String): Flow<Result<CatImageDetails>>
}