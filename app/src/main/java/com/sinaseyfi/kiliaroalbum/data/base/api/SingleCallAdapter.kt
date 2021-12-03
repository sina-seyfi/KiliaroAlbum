package com.sinaseyfi.kiliaroalbum.data.base.api

import com.sinaseyfi.kiliaroalbum.data.base.ConnectionException
import retrofit2.Response

class SingleCallAdapter<T>(
    private val apiCall: suspend () -> Response<T>
) :
    CallAdapter<ResponseWrapper<T>> {
    override suspend fun execute(): ResponseWrapper<T> {
        try {
            val execute = apiCall.invoke()
            if (execute.isSuccessful) {
                val response = execute.body()
                return if(response == null) {
                    ResponseWrapper.Complete()
                } else {
                    ResponseWrapper.Success(response, execute.headers())
                }
            } else {
                // We can implement a strategy to manage exceptions and passing it to upper layers.
                throw ConnectionException()
            }

        } catch (exception: Exception) {
            return ResponseWrapper.Error(ConnectionException())
        }
    }
}