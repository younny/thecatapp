package com.younny.demo.thecatapp.data.remote

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import timber.log.Timber

class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url.toUri().toString()

        val responseStr: String = when {
            uri.endsWith("v1/images/search") -> { getCatImageResponse() }
            uri.matches(".+/images/.+\$".toRegex()) -> { return chain.proceed(chain.request()) }
            else -> {
                Timber.e("<----- no mock cases!! ")
                ""
            }
        }

        return chain.proceed(chain.request())
            .newBuilder()
            .code(200)
            .protocol(Protocol.HTTP_2)
            .message(responseStr)
            .body(
                responseStr.toByteArray()
                    .toResponseBody("application/json; charset=utf-8".toMediaTypeOrNull())
            )
            .addHeader("content-type", "application/json")
            .build()

    }

    private fun getCatDetailsResponse(): String {
        return """
            {
                "width": 600,
                "height": 452,
                "id": "e3c",
                "url": "https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg"
            }
        """.trimIndent()
    }

    private fun getCatImageResponse(): String {
        return """
            [
              {
                "breeds": [],
                "categories": [],
                "id": "e3c",
                "url": "https://25.media.tumblr.com/tumblr_m1yuqjfdy31qejbiro1_500.jpg"
              },
              {
                "breeds": [],
                "categories": [],
                "id": "2kj",
                "url": "https://25.media.tumblr.com/tumblr_m2frwgKzN01r6b7kmo1_500.jpg"
              },
              {
                "breeds": [],
                "categories": [],
                "id": "MTYzMjIxMA",
                "url": "https://25.media.tumblr.com/tumblr_maklk6AJiw1qhwmnpo1_400.jpg"
              },
              {
                "breeds": [],
                "categories": [],
                "id": "ckk",
                "url": "https://cdn2.thecatapi.com/images/ckk.gif"
              },
              {
                "breeds": [],
                "categories": [],
                "id": "ea7",
                "url": "https://25.media.tumblr.com/tumblr_m4qyhzpZts1qcxyrro1_500.jpg"
              },
              {
                "breeds": [],
                "categories": [],
                "id": "4m5",
                "url": "https://25.media.tumblr.com/tumblr_m44w9nI50Y1qzyqubo1_500.jpg"
              },
              {
                "breeds": [],
                "categories": [],
                "id": "fb",
                "url": "https://25.media.tumblr.com/tumblr_luihyxjWY51qzqffro1_500.jpg"
              },
              {
                "breeds": [],
                "categories": [],
                "id": "MTg5NzY0OQ",
                "url": "https://24.media.tumblr.com/tumblr_m87t24YOrf1qze0hyo1_500.jpg"
              },
              {
                "breeds": [],
                "categories": [],
                "id": "bmf",
                "url": "https://24.media.tumblr.com/tumblr_ltq345HHij1qh9eixo1_500.png"
              },
              {
                "breeds": [],
                "categories": [],
                "id": "88n",
                "url": "https://cdn2.thecatapi.com/images/88n.gif"
              }
            ]
        """.trimIndent()
    }
}