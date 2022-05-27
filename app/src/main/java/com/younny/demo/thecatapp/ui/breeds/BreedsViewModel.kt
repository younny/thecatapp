package com.younny.demo.thecatapp.ui.breeds

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.younny.demo.thecatapp.data.BaseCatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BreedsViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val catRepository: BaseCatRepository
) : ViewModel() {

    var state by mutableStateOf(
        BreedsContract.State(
            breeds = null,
            isLoading = true
        )
    )
        private set

    init {
    }

}