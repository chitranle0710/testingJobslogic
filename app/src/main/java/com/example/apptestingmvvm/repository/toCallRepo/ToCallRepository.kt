package com.example.apptestingmvvm.repository.toCallRepo

import com.example.apptestingmvvm.data.entity.ToCallResponse
import com.example.apptestingmvvm.network.ResultWrapper

interface ToCallRepository {
    suspend fun getCallItems(): ResultWrapper<List<ToCallResponse>>
}