package com.younny.demo.thecatapp.ui.catdetails

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.younny.demo.thecatapp.data.BaseCatRepository
import com.younny.demo.thecatapp.data.CatRepository
import com.younny.demo.thecatapp.ui.main.NavigationKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CatDetailsViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val catRepository: BaseCatRepository
) : ViewModel() {

    var state by mutableStateOf(
        CatDetailsContract.State(
            details = null,
            isLoading = true
        )
    )
        private set

    init {
        fetchCatImageDetails()
    }

    @VisibleForTesting
    fun fetchCatImageDetails() {
        viewModelScope.launch {
            val imageId = stateHandle.get<String>(NavigationKeys.Arg.CAT_IMAGE_ID)
                ?: throw IllegalArgumentException("No imageId was given to destination.")
            catRepository.catDetails(imageId)
                .catch { error ->
                    Timber.e("<------ error caught! : $error")
                    state = state.copy(
                        details = null,
                        isLoading = false,
                        error = "${error.message}"
                    )
                }
                .collect { details ->
                    Timber.d("<------ details loaded: $details")
                    state = state.copy(
                        details = details,
                        isLoading = false
                    )
                }
        }
    }
}