package com.example.apptestingmvvm.domain.usecase

import com.example.apptestingmvvm.data.entity.ItemSell
import com.example.apptestingmvvm.domain.repository.toSellRepo.ToSellRepository
import javax.inject.Inject

class InsertItemSellUseCase @Inject constructor(
    private val toSellRepository: ToSellRepository
) {
    suspend fun insertToSell(itemSell: ItemSell): Long = toSellRepository.insertToSell(itemSell)

}