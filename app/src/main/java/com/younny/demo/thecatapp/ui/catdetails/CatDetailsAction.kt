package com.younny.demo.thecatapp.ui.catdetails

import com.younny.demo.thecatapp.ui.common.ViewAction

sealed class CatDetailsAction : ViewAction {
    object CatDetails : CatDetailsAction()
}