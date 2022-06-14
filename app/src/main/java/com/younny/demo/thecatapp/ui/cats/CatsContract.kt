package com.younny.demo.thecatapp.ui.cats

class CatsContract {
    sealed class Effect {
        object Loaded : Effect()
    }
}