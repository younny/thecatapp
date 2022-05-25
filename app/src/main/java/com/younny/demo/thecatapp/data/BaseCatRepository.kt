package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.model.CatImage
import com.younny.demo.thecatapp.data.model.CatImageDetails
import kotlinx.coroutines.flow.Flow

interface BaseCatRepository {
    val catImages: Flow<List<CatImage>>
    fun catDetails(imageId: String): Flow<CatImageDetails>
}