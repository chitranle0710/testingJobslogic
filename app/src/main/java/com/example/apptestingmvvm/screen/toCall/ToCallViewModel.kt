package com.example.apptestingmvvm.screen.toCall

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apptestingmvvm.base.BaseViewModel
import com.example.apptestingmvvm.data.entity.ToCallResponse
import com.example.apptestingmvvm.network.ResultWrapper
import com.example.apptestingmvvm.repository.toCallRepo.ToCallRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToCallViewModel @Inject constructor(
    private val toCallRepository: ToCallRepository
) : BaseViewModel() {
    val mutableListCallLiveData = MutableLiveData<List<ToCallResponse>>()
    fun getListItemsCall() {
        loadingData.postValue(true)
        viewModelScope.safeLaunch {
            when (val result = toCallRepository.getCallItems()) {
                is ResultWrapper.Success -> {
                    loadingData.postValue(false)
                    mutableListCallLiveData.postValue(result.data)
                }
                else -> {
                    loadingData.postValue(false)
                }
            }
        }
    }
}