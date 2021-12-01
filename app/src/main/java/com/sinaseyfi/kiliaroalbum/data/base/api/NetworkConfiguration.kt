package com.sinaseyfi.kiliaroalbum.data.base.api

import okhttp3.Interceptor

interface NetworkConfiguration {
    fun getInterceptors() : List<Interceptor>
}