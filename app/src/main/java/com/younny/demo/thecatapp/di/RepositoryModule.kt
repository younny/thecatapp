package com.younny.demo.thecatapp.di

import com.younny.demo.thecatapp.data.BaseCatRepository
import com.younny.demo.thecatapp.data.CatRepository
import com.younny.demo.thecatapp.data.local.CatDao
import com.younny.demo.thecatapp.data.remote.CatApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCatRepository(
        catDao: CatDao,
        catApiService: CatApiService
    ) = CatRepository(catDao, catApiService) as BaseCatRepository
}