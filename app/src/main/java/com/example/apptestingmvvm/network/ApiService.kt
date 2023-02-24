package com.example.apptestingmvvm.network

import com.example.apptestingmvvm.data.entity.Animal
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @GET("api/list/")
    suspend fun getList(
        @Query("id") id: String?
    ): Response<List<Animal>>
}