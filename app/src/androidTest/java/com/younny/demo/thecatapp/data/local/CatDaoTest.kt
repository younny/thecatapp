package com.younny.demo.thecatapp.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.younny.demo.thecatapp.data.model.CatImage
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class CatDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("test_db")
    lateinit var catDatabase: CatDatabase

    private lateinit var catDao: CatDao

    @Before
    fun setup() {
        hiltRule.inject()
        catDao = catDatabase.catDao()
    }

    @After
    @Throws(IOException::class)
    fun teardown() {
        catDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeCatAndRead() = runBlocking {
        val catImage = CatImage(id = "0", url = "https://abc.com", breeds = listOf(), categories = listOf())

        catDao.insertAll(listOf(catImage))
        val cats = catDao.getCatImages().first()
        assert(cats.size == 1)
        val item = cats[0]
        assert(item.id == "0")
    }
}