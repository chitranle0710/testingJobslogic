package com.example.apptestingmvvm.repository.toBuyRepo

import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.network.ResultWrapper

interface ToBuyRepository {
    suspend fun getListToBuyItems(): ResultWrapper<List<ToBuyResponse>>
}