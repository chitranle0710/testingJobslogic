package com.example.apptestingmvvm.screen.toBuy

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apptestingmvvm.base.BaseViewModel
import com.example.apptestingmvvm.data.entity.ItemSell
import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.data.entity.ToCallResponse
import com.example.apptestingmvvm.domain.usecase.GetItemBuyUseCase
import com.example.apptestingmvvm.domain.usecase.GetItemSellUseCase
import com.example.apptestingmvvm.domain.usecase.InsertItemSellUseCase
import com.example.apptestingmvvm.network.ResultWrapper
import com.example.apptestingmvvm.domain.repository.toBuyRepo.ToBuyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToBuyViewModel @Inject constructor(
    private val useCase: GetItemBuyUseCase,
    private val insertItemSellUseCase: InsertItemSellUseCase,
    private val getItemSellUseCase: GetItemSellUseCase
) : BaseViewModel() {

    val mutableListBuyLiveData = MutableLiveData<List<ToBuyResponse>>()

    fun getListBuyItems() {
        loadingData.postValue(true)
        viewModelScope.safeLaunch {
            when (val result = useCase.getListToBuyItems()) {
                is ResultWrapper.Success -> {
                    loadingData.postValue(false)
                    mutableListBuyLiveData.postValue(result.data)
                }
                else -> {
                    loadingData.postValue(false)
                }
            }
        }
    }

    fun insertItemToSell(itemSell: ItemSell) {
        viewModelScope.safeLaunch {
            val sellItemsList = getItemSellsList()
            if (sellItemsList.find { it.name == itemSell.name && it.price == itemSell.price && it.quantity == itemSell.quantity } == null) {
                insertItemSellUseCase.insertToSell(itemSell)
            }
        }
    }

    private suspend fun getItemSellsList(): List<ItemSell> {
        return getItemSellUseCase.getListItemSell()
    }
}