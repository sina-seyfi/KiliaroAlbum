package com.sinaseyfi.kiliaroalbum.data.base.api

interface CallAdapter<R> {
    suspend fun execute(): R
}