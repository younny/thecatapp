package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.local.CatDao
import com.younny.demo.thecatapp.data.model.CatImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockDao : CatDao {
    override fun getCatImages(): Flow<List<CatImage>> = flow {
        emit(listOf())
    }

    override suspend fun insertAll(images: List<CatImage>) {
    }
}