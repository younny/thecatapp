package com.younny.demo.thecatapp.ui.catdetails

import com.younny.demo.thecatapp.ui.common.ViewIntent

sealed class CatDetailsIntent : ViewIntent {
    object LoadCatDetails : CatDetailsIntent()
}