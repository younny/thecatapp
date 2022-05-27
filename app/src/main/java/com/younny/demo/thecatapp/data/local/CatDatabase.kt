package com.younny.demo.thecatapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.younny.demo.thecatapp.data.model.CatImage
import com.younny.demo.thecatapp.data.model.CatImageDetails

@Database(entities = [CatImage::class, CatImageDetails::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class CatDatabase : RoomDatabase() {
    abstract fun catDao(): CatDao
}