package com.example.apptestingmvvm.view.toSell

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
            loadingData.postValue(true)
            val result = getItemSellUseCase.getListItemSell()
            if (result.isNotEmpty()) {
                loadingData.postValue(false)
                showListSellMutableLiveData.postValue(result)
            } else {
                loadingData.postValue(false)
                errorMessage.postValue("Empty list!!!")
            }
        }
    }
}