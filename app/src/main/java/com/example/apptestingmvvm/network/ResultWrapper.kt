package com.example.apptestingmvvm.network

sealed class ResultWrapper<T : Any> {
    data class Success<T : Any>(val data: T) : ResultWrapper<T>()
    data class Error<T : Any>(val code: Int, val message: String?) : ResultWrapper<T>()
    data class Exception<T : Any>(val e: Throwable) : ResultWrapper<T>()
}