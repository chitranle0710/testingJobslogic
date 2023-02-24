package com.example.apptestingmvvm.domain.usecase

import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.network.ResultWrapper
import com.example.apptestingmvvm.repository.toBuyRepo.ToBuyRepository
import javax.inject.Inject

class GetItemBuyUseCase @Inject constructor(
    private val repository: ToBuyRepository
) {
    suspend fun getListToBuyItems(): ResultWrapper<List<ToBuyResponse>> =
        repository.getListToBuyItems()
}