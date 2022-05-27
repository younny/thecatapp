package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.MockResponse.MOCK_CAT_IMAGES
import com.younny.demo.thecatapp.data.MockResponse.MOCK_CAT_IMAGE_DETAILS_0
import com.younny.demo.thecatapp.data.MockResponse.mockImageDetails
import com.younny.demo.thecatapp.data.local.CatDao
import com.younny.demo.thecatapp.data.model.CatImage
import com.younny.demo.thecatapp.data.model.CatImageDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockDao : CatDao {
    override fun getCatImages(): Flow<List<CatImage>> = flow {
        emit(MOCK_CAT_IMAGES)
    }

    override suspend fun insertAllCatImages(images: List<CatImage>) {
    }

    override fun getCatImageDetails(imageId: String): Flow<CatImageDetails> = flow {
        emit(mockImageDetails(imageId))
    }

    override suspend fun insertCatImageDetails(catImageDetails: CatImageDetails) {
    }
}