package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.MockResponse.MOCK_CAT_IMAGES
import com.younny.demo.thecatapp.data.MockResponse.MOCK_CAT_IMAGE_DETAILS_0
import com.younny.demo.thecatapp.data.local.CatDao
import com.younny.demo.thecatapp.data.remote.CatApiService
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CatRepositoryTest {
    lateinit var mockCatDao: CatDao
    lateinit var mockCatApiService: CatApiService

    @Before
    fun `set up`() {
        mockCatApiService = MockApiService()
        mockCatDao = MockDao()
    }

    @Test
    fun `load cat images success`() = runBlocking {
        val repository = CatRepository(mockCatDao, mockCatApiService)
        val firstItem = repository.catImages.first()

        assert(firstItem == MOCK_CAT_IMAGES)
    }

    @Test
    fun `load cat image details success`() = runBlocking {
        val repository = CatRepository(mockCatDao, mockCatApiService)
        val firstItem = repository.catImageDetails("0").first()

        assert(firstItem == MOCK_CAT_IMAGE_DETAILS_0)
    }
}