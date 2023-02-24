package com.example.apptestingmvvm.domain.usecase

import com.example.apptestingmvvm.data.entity.ItemSell
import com.example.apptestingmvvm.domain.repository.toSellRepo.ToSellRepository
import javax.inject.Inject

class GetItemSellUseCase @Inject constructor(
    private val toSellRepository: ToSellRepository
) {
    suspend fun getListItemSell(): MutableList<ItemSell> = toSellRepository.getListItemSell()
}