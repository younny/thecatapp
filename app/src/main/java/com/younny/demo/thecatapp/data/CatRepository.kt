package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.local.CatDao
import com.younny.demo.thecatapp.data.model.CatImage
import com.younny.demo.thecatapp.data.model.CatImageDetails
import com.younny.demo.thecatapp.data.remote.CatApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatRepository @Inject constructor(
    private val catDao: CatDao,
    private val catApiService: CatApiService
): BaseCatRepository {
    override val catImages: Flow<List<CatImage>> = flow {
        val images = catApiService.fetchCatImages()
        catDao.insertAll(images)
        emit(images)
    }.flowOn(Dispatchers.IO)

    override fun catDetails(imageId: String): Flow<CatImageDetails> = flow {
        val details = catApiService.fetchImageDetails(imageId)
        //todo insert to database
        emit(details)
    }.flowOn(Dispatchers.IO)
}