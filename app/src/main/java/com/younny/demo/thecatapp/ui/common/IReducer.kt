package com.younny.demo.thecatapp.ui.common

interface IReducer<STATE, T : Any> {
    fun reduce(result: Result<T>, state: STATE): STATE
}