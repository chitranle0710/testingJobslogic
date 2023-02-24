package com.example.apptestingmvvm.repository.toCallRepo

import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.data.entity.ToCallResponse
import com.example.apptestingmvvm.network.ApiService
import com.example.apptestingmvvm.network.BaseService
import com.example.apptestingmvvm.network.ResultWrapper
import com.example.apptestingmvvm.repository.toBuyRepo.ToBuyRepository
import javax.inject.Inject

class ToCallRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ToCallRepository, BaseService() {
    override suspend fun getCallItems(): ResultWrapper<List<ToCallResponse>> = handleApi {
        apiService.getCallItems()
    }

}