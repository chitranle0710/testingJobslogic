package com.example.apptestingmvvm.domain.repository.toSellRepo

import com.example.apptestingmvvm.data.entity.ItemSell
import com.example.apptestingmvvm.di.local.ItemSellDAO
import javax.inject.Inject


class ToSellRepositoryImpl @Inject constructor(
    private val dao: ItemSellDAO
) : ToSellRepository {
    override suspend fun insertToSell(itemSell: ItemSell): Long = dao.insertItem(itemSell)

    override suspend fun getListItemSell(): MutableList<ItemSell> = dao.loadAll()
}