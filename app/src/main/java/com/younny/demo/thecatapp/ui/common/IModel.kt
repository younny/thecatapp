package com.younny.demo.thecatapp.ui.common

import kotlinx.coroutines.flow.Flow

interface IModel<STATE, INTENT> {
    val state : Flow<STATE?>
    fun dispatchIntent(intent: INTENT)
}