package com.younny.demo.thecatapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.younny.demo.thecatapp.data.model.CatImage
import com.younny.demo.thecatapp.data.model.CatImageDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface CatDao {

    @Query("SELECT * FROM cat_table")
    fun getCatImages(): Flow<List<CatImage>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCatImages(images: List<CatImage>)

    @Query("SELECT * FROM cat_image_details_table WHERE id == :imageId")
    fun getCatImageDetails(imageId: String): Flow<CatImageDetails>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCatImageDetails(catImageDetails: CatImageDetails)
}