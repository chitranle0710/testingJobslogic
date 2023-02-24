package com.example.apptestingmvvm.di.local

import androidx.room.*
import com.example.apptestingmvvm.data.entity.ItemSell

@Dao
interface ItemSellDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(photo: ItemSell): Long

    @Query("SELECT * FROM ItemToSell")
    suspend fun loadAll(): MutableList<ItemSell>

}