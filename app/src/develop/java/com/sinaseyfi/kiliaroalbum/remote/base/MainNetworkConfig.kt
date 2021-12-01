package com.sinaseyfi.kiliaroalbum.remote.base

import com.sinaseyfi.kiliaroalbum.data.base.api.NetworkConfiguration
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class MainNetworkConfig @Inject constructor(
//    private val mainInterceptor: MainInterceptor
): NetworkConfiguration {

    override fun getInterceptors(): List<Interceptor> =
        listOf(getLogInterceptor())

    private fun getLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

}