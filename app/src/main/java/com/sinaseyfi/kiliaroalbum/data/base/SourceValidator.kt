package com.sinaseyfi.kiliaroalbum.data.base

interface SourceValidator<T> {
    suspend fun isValid(): Boolean
    suspend fun updated(source: T?)
}