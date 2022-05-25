package com.younny.demo.thecatapp.di

import android.app.Application
import androidx.room.Room
import com.younny.demo.thecatapp.data.local.CatDao
import com.younny.demo.thecatapp.data.local.CatDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application): CatDatabase {
        return Room.databaseBuilder(application, CatDatabase::class.java, "cat-db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesCatDao(database: CatDatabase): CatDao {
        return database.catDao()
    }
}