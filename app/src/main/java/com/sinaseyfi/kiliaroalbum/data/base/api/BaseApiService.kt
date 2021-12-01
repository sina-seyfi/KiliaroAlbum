package com.sinaseyfi.kiliaroalbum.data.base.api

import com.sinaseyfi.kiliaroalbum.utils.Resource
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject

abstract class BaseApiService<S> constructor(private val serviceClass: Class<S>) :
    API<S> {

    @Inject
    lateinit var retrofit: Retrofit

    override val apiService: S by lazy {
        create()
    }

    protected suspend fun <T> execute(apiCall: suspend () -> T): Resource<T> =
        try {
            Resource.success(apiCall.invoke())
        } catch (e: Exception) {
            Resource.error(e, null)
        }

    protected suspend fun <T> executionWithMessage(apiCall: suspend () -> Response<T>): Result<T> {
        return when (val adapter = SingleCallAdapter(apiCall).execute()) {
            is ResponseWrapper.Success -> Result(adapter.data, adapter.headers)
            is ResponseWrapper.Error -> throw  adapter.exception
            is ResponseWrapper.Complete -> Result()
            else -> throw IllegalStateException()
        }
    }

    private fun create(): S {
        return retrofit.create(serviceClass)
    }

}