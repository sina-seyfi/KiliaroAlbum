package com.sinaseyfi.kiliaroalbum.data.base.api

import com.sinaseyfi.kiliaroalbum.utils.Resource
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

abstract class BaseApiService<S> constructor(private val serviceClass: Class<S>) :
    API<S> {

    @Inject
    lateinit var retrofit: Retrofit

    override val apiService: S by lazy {
        create()
    }

    protected suspend fun <T> execute(apiCall: suspend () -> Response<T>): Resource<T> =
        when(val adapter = SingleCallAdapter(apiCall).execute()) {
            is ResponseWrapper.Success -> Resource.success(adapter.data)
            is ResponseWrapper.Error -> Resource.error(adapter.exception, null)
            is ResponseWrapper.Complete -> Resource.success(null)
            else -> throw IllegalStateException()
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