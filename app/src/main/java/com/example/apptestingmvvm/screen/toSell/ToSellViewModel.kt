package com.example.apptestingmvvm.screen.toSell

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apptestingmvvm.base.BaseViewModel
import com.example.apptestingmvvm.data.entity.ItemSell
import com.example.apptestingmvvm.domain.usecase.GetItemSellUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToSellViewModel @Inject constructor(
    private val getItemSellUseCase: GetItemSellUseCase
) : BaseViewModel() {

    val showListSellMutableLiveData = MutableLiveData<MutableList<ItemSell>>()
    val errorMessage = MutableLiveData<String>()

    fun getItemSell() {
        viewModelScope.safeLaunch {
            val result = getItemSellUseCase.getListItemSell()
            if (result.isNotEmpty()) {
                showListSellMutableLiveData.postValue(result)
            } else {
                errorMessage.postValue("Empty list!!!")
            }
        }
    }
}