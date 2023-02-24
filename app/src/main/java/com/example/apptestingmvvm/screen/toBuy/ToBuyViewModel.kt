package com.example.apptestingmvvm.screen.toBuy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apptestingmvvm.base.BaseViewModel
import com.example.apptestingmvvm.data.entity.ToBuyResponse
import com.example.apptestingmvvm.data.entity.ToCallResponse
import com.example.apptestingmvvm.network.ResultWrapper
import com.example.apptestingmvvm.repository.toBuyRepo.ToBuyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToBuyViewModel @Inject constructor(
    private val toBuyRepository: ToBuyRepository
) : BaseViewModel() {

    val mutableListBuyLiveData = MutableLiveData<List<ToBuyResponse>>()

    fun getListBuyItems() {
        loadingData.postValue(true)
        viewModelScope.safeLaunch {
            when (val result = toBuyRepository.getListToBuyItems()) {
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
}