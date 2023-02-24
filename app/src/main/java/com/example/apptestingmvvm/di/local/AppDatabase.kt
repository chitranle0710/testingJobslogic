package com.example.apptestingmvvm.di.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apptestingmvvm.data.entity.ItemSell

@Database(entities = [ItemSell::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDAO(): ItemSellDAO

    companion object {
        const val DB_NAME = "MyDatabase.db"
    }

}