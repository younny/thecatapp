package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.MockResponse.MOCK_CAT_IMAGES
import com.younny.demo.thecatapp.data.MockResponse.MOCK_CAT_IMAGE_DETAILS_0
import com.younny.demo.thecatapp.data.model.*
import com.younny.demo.thecatapp.data.remote.CatApiService
import retrofit2.Response

class MockApiService : CatApiService {
    override suspend fun fetchCatImages(): Response<List<CatImage>> {
        return Response.success(MOCK_CAT_IMAGES)
    }

    override suspend fun fetchImageDetails(imageId: String): Response<CatImageDetails> {
        return Response.success(MOCK_CAT_IMAGE_DETAILS_0)
    }

    override suspend fun getVotes(subId: String?): Response<List<Vote>> {
        TODO("Not yet implemented")
    }

    override suspend fun getVote(voteId: String): Response<Vote> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategories(): Response<List<Category>> {
        TODO("Not yet implemented")
    }

    override suspend fun getBreeds(limit: Int?, page: Int?): Response<List<Breed>> {
        TODO("Not yet implemented")
    }

    override suspend fun getBreed(breedId: Int): Response<List<BreedDetails>> {
        TODO("Not yet implemented")
    }

}