package com.younny.demo.thecatapp.data

import com.younny.demo.thecatapp.data.model.CatImage
import com.younny.demo.thecatapp.data.model.CatImageDetails

object MockResponse {
    val MOCK_CAT_IMAGES = listOf(
        CatImage(id = "0", url = "https://foo.boo.com", breeds = listOf(), categories = listOf()),
        CatImage(id = "1", url = "https://foo1.boo1.com", breeds = listOf(), categories = listOf())
    )

    val MOCK_CAT_IMAGE_DETAILS_0 = CatImageDetails(id = "0", url = "https://foo.boo.com", width = 1, height = 1)
    val MOCK_CAT_IMAGE_DETAILS_1 = CatImageDetails(id = "1", url = "https://foo.boo.com", width = 1, height = 1)

}