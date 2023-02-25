package com.example.apptestingmvvm.domain.repository.toCallRepo

import com.example.apptestingmvvm.data.entity.ToCallResponse
import com.example.apptestingmvvm.network.ApiService
import com.example.apptestingmvvm.base.BaseService
import com.example.apptestingmvvm.network.ResultWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ToCallRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ToCallRepository, BaseService() {
    override suspend fun getCallItems(): ResultWrapper<List<ToCallResponse>> =
        callApi {
            apiService.getCallItems()
        }

}