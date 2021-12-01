package com.sinaseyfi.kiliaroalbum.data.base.api

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

                throw Exception()


            }

        } catch (exception: Exception) {
            return ResponseWrapper.Error(exception)
        }
    }
}