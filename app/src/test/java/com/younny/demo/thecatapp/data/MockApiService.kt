package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.MockResponse.MOCK_CAT_IMAGES
import com.younny.demo.thecatapp.data.MockResponse.MOCK_CAT_IMAGE_DETAILS_0
import com.younny.demo.thecatapp.data.model.*
import com.younny.demo.thecatapp.data.remote.CatApiService

class MockApiService : CatApiService {
    override suspend fun fetchCatImages(): List<CatImage> {
        return MOCK_CAT_IMAGES
    }

    override suspend fun fetchImageDetails(imageId: String): CatImageDetails {
        return MOCK_CAT_IMAGE_DETAILS_0
    }

    override suspend fun getVotes(subId: String?): List<Vote> {
        TODO("Not yet implemented")
    }

    override suspend fun getVote(voteId: String): Vote {
        TODO("Not yet implemented")
    }

    override suspend fun getCategories(): List<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun getBreeds(limit: Int?, page: Int?): List<Breed> {
        TODO("Not yet implemented")
    }

    override suspend fun getBreed(breedId: Int): List<BreedDetails> {
        TODO("Not yet implemented")
    }
}