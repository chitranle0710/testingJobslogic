package com.example.apptestingmvvm.network

import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.data.entity.ToCallResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("imkhan334/demo-1/call")
    suspend fun getCallItems(): Response<List<ToCallResponse>>

    @GET("imkhan334/demo-1/buy")
    suspend fun getBuyItems(): Response<List<ToBuyResponse>>
}