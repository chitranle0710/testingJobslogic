package com.example.apptestingmvvm.network

import retrofit2.HttpException
import retrofit2.Response

abstract class BaseService {
    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): ResultWrapper<T> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                ResultWrapper.Success(body)
            } else {
                ResultWrapper.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            ResultWrapper.Exception(e)
        } catch (e: Throwable) {
            ResultWrapper.Exception(e)
        }
    }
}