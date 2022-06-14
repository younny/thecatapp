package com.younny.demo.thecatapp.ui.cats

import com.younny.demo.thecatapp.ui.common.ViewAction

sealed class CatsAction : ViewAction {
    object AllCatImages : CatsAction()
}