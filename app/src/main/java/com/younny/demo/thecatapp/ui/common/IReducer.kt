package com.younny.demo.thecatapp.ui.common

import com.younny.demo.thecatapp.data.common.Result

interface IReducer<STATE, T : Any> {
    fun reduce(result: Result<T>, state: STATE): STATE
}