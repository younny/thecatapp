package com.younny.demo.thecatapp.ui.common

interface IViewRenderer<STATE> {
    fun render(state: STATE)
}