package com.example.apptestingmvvm.domain.repository.toBuyRepo

import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.network.ApiService
import com.example.apptestingmvvm.base.BaseService
import com.example.apptestingmvvm.network.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ToBuyRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ToBuyRepository, BaseService() {
    override suspend fun getListToBuyItems(): ResultWrapper<List<ToBuyResponse>> = callApi {
        apiService.getBuyItems()
    }

}