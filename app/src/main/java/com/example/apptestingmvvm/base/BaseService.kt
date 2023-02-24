package com.example.apptestingmvvm.base

import com.example.apptestingmvvm.network.ResultWrapper
import retrofit2.HttpException
import retrofit2.Response

abstract class BaseService {
    suspend fun <T : Any> callApi(
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