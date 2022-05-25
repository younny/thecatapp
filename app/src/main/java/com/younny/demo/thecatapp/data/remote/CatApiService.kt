package com.younny.demo.thecatapp.data.remote

import com.younny.demo.thecatapp.data.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CatApiService {

    @GET("v1/images/search")
    suspend fun fetchCatImages(
//        @Query("size") size: String? = "med",
//        @Query("mime_types") mimeTypes: String? = "jpg,gif,png",
//        @Query("format") format: String? = "json",
//        @Query("order") order: String = "RANDOM",
//        @Query("page") page: Int? = 0,
//        @Query("limit") limit: Int? = 1,
//        @Query("category_ids") categories: String? = "",
//        @Query("breed_ids") breeds: String? = "",
//        @Query("has_breeds") hasBreeds: Int? = 0
    ): List<CatImage>

    @GET("v1/images/{image_id}")
    suspend fun fetchImageDetails(
        @Path(value = "image_id") imageId: String,
//        @Query("sub_id") subId: String?,
//        @Query("size") size: String?,
//        @Query("include_vote") includeVote: Boolean?,
//        @Query("include_favourite") includeFavourite: Boolean?
    ): CatImageDetails

    @GET("v1/votes")
    suspend fun getVotes(
        @Path(value = "sub_id") subId: String?
    ): List<Vote>

    @GET("v1/votes/{vote_id}")
    suspend fun getVote(
        @Path(value = "vote_id") voteId: String
    ): Vote

//    @GET("v1/favourites")
//    suspend fun getFavourites(
//        @Path(value = "sub_id") subId: String?
//    )
//
//    @GET("v1/favourites/{favourite_id}")
//    suspend fun getFavourite(
//        @Path(value = "favourite_id") favouriteId: String
//    )

    @GET("v1/categories")
    suspend fun getCategories(): List<Category>

    @GET("v1/breeds")
    suspend fun getBreeds(
        @Query("limit") limit: Int? = 10,
        @Query("page") page: Int? = 0
    ): List<Breed>

    @GET("v1/breeds/{breed_id}")
    suspend fun getBreed(
        @Path(value = "breed_id") breedId: Int
    ): List<BreedDetails>
}