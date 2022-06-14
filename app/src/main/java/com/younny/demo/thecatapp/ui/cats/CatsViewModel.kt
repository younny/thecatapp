package com.younny.demo.thecatapp.ui.cats

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.viewModelScope
import com.younny.demo.thecatapp.data.BaseCatRepository
import com.younny.demo.thecatapp.ui.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val catRepository: BaseCatRepository
) : BaseViewModel<CatsIntent, CatsAction, CatsState>() {

    val effects = Channel<CatsContract.Effect>(UNLIMITED)

    @VisibleForTesting
    fun fetchCatImages() {
        viewModelScope.launch {
            catRepository.catImages.collect {
                    update(it.reduce())
                    effects.send(CatsContract.Effect.Loaded)
                }
        }
    }

    override fun intentToAction(intent: CatsIntent): CatsAction {
        return when(intent) {
            is CatsIntent.LoadAllCatImages -> CatsAction.AllCatImages
        }
    }

    override fun handleAction(action: CatsAction) {
        when (action) {
            is CatsAction.AllCatImages -> fetchCatImages()
        }
    }
}
