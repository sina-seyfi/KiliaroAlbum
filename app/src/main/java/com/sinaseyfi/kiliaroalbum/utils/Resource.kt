package com.sinaseyfi.kiliaroalbum.utils

import java.lang.Exception

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(error: Exception, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, error.message)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, null)
        }

    }

}
