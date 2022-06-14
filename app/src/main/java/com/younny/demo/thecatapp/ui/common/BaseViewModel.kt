package com.younny.demo.thecatapp.ui.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<INTENT : ViewIntent, ACTION : ViewAction, STATE : ViewState> : ViewModel(), IModel<STATE, INTENT> {
    private val _state = MutableStateFlow<STATE?>(null)
    override val state = _state.asStateFlow()

    fun update(state: STATE) {
        _state.update {
            state
        }
    }
    override fun dispatchIntent(intent: INTENT) {
        handleAction(intentToAction(intent))
    }

    abstract fun intentToAction(intent: INTENT): ACTION
    abstract fun handleAction(action: ACTION)
}