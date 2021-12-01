package com.sinaseyfi.kiliaroalbum.data.base.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class MainInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request().newBuilder().build())
    }
}