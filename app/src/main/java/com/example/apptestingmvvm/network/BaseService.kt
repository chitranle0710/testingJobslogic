package com.example.apptestingmvvm.network

import retrofit2.HttpException
import retrofit2.Response

abstract class BaseService {
    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        return try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                NetworkResult.Success(body)
            } else {
                NetworkResult.Error(code = response.code(), message = response.message())
            }
        } catch (e: HttpException) {
            NetworkResult.Exception(e)
        } catch (e: Throwable) {
            NetworkResult.Exception(e)
        }
    }
}