package com.younny.demo.thecatapp.ui.cats

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.younny.demo.thecatapp.data.BaseCatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val catRepository: BaseCatRepository
) : ViewModel() {

    var state by mutableStateOf(
        CatsContract.State(
            catImages = listOf(),
            isLoading = true
        )
    )
        private set

    val effects = Channel<CatsContract.Effect>(UNLIMITED)

    init {
        fetchCatImages()
    }

    @VisibleForTesting
    fun fetchCatImages() {
        viewModelScope.launch {
            catRepository.catImages
                .collect { cats ->
                    state = state.copy(
                        catImages = cats,
                        isLoading = false
                    )
                    effects.send(CatsContract.Effect.Loaded)
                }
        }
    }
}