package com.sinaseyfi.kiliaroalbum.data.base.api

import okhttp3.Headers

open class ResponseWrapper<out T> {
    data class Success<out T>(val data: T?, val headers: Headers) :
        ResponseWrapper<T>()

    data class Error(val exception: Exception) : ResponseWrapper<Nothing>()
    class Complete : ResponseWrapper<Nothing>()
}