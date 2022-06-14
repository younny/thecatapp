package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.common.CallErrors
import com.younny.demo.thecatapp.data.common.Result
import com.younny.demo.thecatapp.data.local.CatDao
import com.younny.demo.thecatapp.data.model.CatImage
import com.younny.demo.thecatapp.data.model.CatImageDetails
import com.younny.demo.thecatapp.data.remote.CatApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatRepository @Inject constructor(
    private val catDao: CatDao,
    private val catApiService: CatApiService
): BaseCatRepository {
    override val catImages: Flow<Result<List<CatImage>>> = flow {
        catApiService.fetchCatImages().run {
            if (isSuccessful) {
                if (body() == null) {
                    emit(Result.Error(CallErrors.ErrorEmptyData))
                } else {
                    val images = body()!!
                    catDao.insertAllCatImages(images)
                    emit(Result.Success(images))
                }
            } else {
                emit(Result.Error(CallErrors.ErrorServer))
            }
        }
    }.flowOn(Dispatchers.IO)

    override fun catImageDetails(imageId: String): Flow<Result<CatImageDetails>> = flow {
        catApiService.fetchImageDetails(imageId).run {
            if (isSuccessful) {
                if (body() == null) {
                    emit(Result.Error(CallErrors.ErrorEmptyData))
                } else {
                    val details = body()!!
                    catDao.insertCatImageDetails(details)
                    emit(Result.Success(details))
                }
            } else {
                emit(Result.Error(CallErrors.ErrorServer))
            }
        }
    }.flowOn(Dispatchers.IO)
}