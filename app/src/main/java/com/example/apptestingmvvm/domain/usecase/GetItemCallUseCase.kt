package com.example.apptestingmvvm.domain.usecase

import com.example.apptestingmvvm.data.entity.ToCallResponse
import com.example.apptestingmvvm.network.ResultWrapper
import com.example.apptestingmvvm.domain.repository.toCallRepo.ToCallRepository
import javax.inject.Inject

class GetItemCallUseCase @Inject constructor(
    private val repository: ToCallRepository
) {
    suspend fun getCallItems(): ResultWrapper<List<ToCallResponse>> = repository.getCallItems()
}