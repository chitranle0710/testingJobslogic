package com.example.apptestingmvvm.domain.repository.toBuyRepo

import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.network.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface ToBuyRepository {
    suspend fun getListToBuyItems(): ResultWrapper<List<ToBuyResponse>>
}