package com.younny.demo.thecatapp.ui.catdetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.younny.demo.thecatapp.MainCoroutineRule
import com.younny.demo.thecatapp.data.MockCatRepository
import com.younny.demo.thecatapp.ui.cats.CatsState
import com.younny.demo.thecatapp.ui.main.NavigationKeys
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CatDetailsViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: CatDetailsViewModel
    private val stateHandle = SavedStateHandle(mutableMapOf<String, Any>(NavigationKeys.Arg.CAT_IMAGE_ID to "1"))

    @Before
    fun setup() {
        viewModel = CatDetailsViewModel(
            stateHandle = stateHandle,
            catRepository = MockCatRepository()
        )
    }

    @After
    fun teardown() {
    }

    @Test
    fun `fetch cat details success`() = runTest {
        viewModel.fetchCatImageDetails()
        advanceUntilIdle()
        val details = (viewModel.state.value as CatDetailsState.ResultCatDetails).data
        assert(details.id == "1")
        assert(viewModel.state.value != CatDetailsState.Loading)
    }

}