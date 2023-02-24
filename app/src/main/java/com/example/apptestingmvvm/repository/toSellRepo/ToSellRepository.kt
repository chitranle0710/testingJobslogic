package com.example.apptestingmvvm.repository.toSellRepo

import com.example.apptestingmvvm.data.entity.ItemSell

interface ToSellRepository {
    suspend fun insertToSell(itemSell: ItemSell): Long
    suspend fun getListItemSell(): MutableList<ItemSell>
}