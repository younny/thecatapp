package com.younny.demo.thecatapp.ui.cats

import com.younny.demo.thecatapp.ui.common.ViewIntent

sealed class CatsIntent : ViewIntent {
    object LoadAllCatImages : CatsIntent()
}