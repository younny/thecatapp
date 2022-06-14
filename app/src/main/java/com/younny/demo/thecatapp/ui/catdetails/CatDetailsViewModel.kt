package com.younny.demo.thecatapp.ui.catdetails

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.younny.demo.thecatapp.data.BaseCatRepository
import com.younny.demo.thecatapp.ui.common.BaseViewModel
import com.younny.demo.thecatapp.ui.main.NavigationKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatDetailsViewModel @Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val catRepository: BaseCatRepository
) : BaseViewModel<CatDetailsIntent, CatDetailsAction, CatDetailsState>() {

    @VisibleForTesting
    fun fetchCatImageDetails() {
        viewModelScope.launch {
            val imageId = stateHandle.get<String>(NavigationKeys.Arg.CAT_IMAGE_ID)
                ?: throw IllegalArgumentException("No imageId was given to destination.")
            catRepository.catImageDetails(imageId)
                .collect {
                    update(it.reduce())
                }
        }
    }

    override fun intentToAction(intent: CatDetailsIntent): CatDetailsAction {
        return when (intent) {
            is CatDetailsIntent.LoadCatDetails -> CatDetailsAction.CatDetails
        }
    }

    override fun handleAction(action: CatDetailsAction) {
        when (action) {
            is CatDetailsAction.CatDetails -> fetchCatImageDetails()
        }
    }
}