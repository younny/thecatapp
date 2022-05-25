package com.younny.demo.thecatapp.ui.cats

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.younny.demo.thecatapp.MainCoroutineRule
import com.younny.demo.thecatapp.data.MockCatRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class CatsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: CatsViewModel

    @Before
    fun setup() {
        viewModel = CatsViewModel(MockCatRepository())
    }

    @After
    fun teardown() {
    }

    @Test
    fun `fetch cat images success`() = runTest {
        viewModel.fetchCatImages()
        advanceUntilIdle()
        assert(viewModel.state.catImages.size == 2)
        assert(!viewModel.state.isLoading)
        assert(viewModel.effects.receive() == CatsContract.Effect.Loaded)
    }
}