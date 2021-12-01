package com.sinaseyfi.kiliaroalbum.data.base.api

import okhttp3.Headers

data class Result<T>(val data: T? = null, val headers: Headers? = null)