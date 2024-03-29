package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.common.Result
import com.younny.demo.thecatapp.data.model.CatImageDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MockCatRepository : BaseCatRepository {

    override val catImages = flowOf(Result.Success(MockResponse.MOCK_CAT_IMAGES))

    override fun catImageDetails(imageId: String): Flow<Result<CatImageDetails>> {
        return flowOf(
            Result.Success(
                when (imageId) {
                    "0" -> MockResponse.MOCK_CAT_IMAGE_DETAILS_0
                    "1" -> MockResponse.MOCK_CAT_IMAGE_DETAILS_1
                    else -> throw Exception()
                }
            )
        )
    }

    private var shouldReturnNetworkError = false

}