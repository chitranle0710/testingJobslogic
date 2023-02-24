package com.example.apptestingmvvm.domain.repository.toBuyRepo

import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.network.ApiService
import com.example.apptestingmvvm.network.BaseService
import com.example.apptestingmvvm.network.ResultWrapper
import javax.inject.Inject

class ToBuyRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ToBuyRepository, BaseService() {
    override suspend fun getListToBuyItems(): ResultWrapper<List<ToBuyResponse>> = handleApi {
        apiService.getBuyItems()
    }
}