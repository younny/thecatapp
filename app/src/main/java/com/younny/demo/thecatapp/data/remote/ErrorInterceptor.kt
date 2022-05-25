package com.younny.demo.thecatapp.data.remote

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response


class ErrorInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (response.code == 400) {
            //TODO
        }

        return response
    }
}