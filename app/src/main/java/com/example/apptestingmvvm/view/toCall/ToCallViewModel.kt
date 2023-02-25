package com.example.apptestingmvvm.view.toCall

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apptestingmvvm.base.BaseViewModel
import com.example.apptestingmvvm.data.entity.ToCallResponse
import com.example.apptestingmvvm.domain.usecase.GetItemCallUseCase
import com.example.apptestingmvvm.network.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ToCallViewModel @Inject constructor(
    private val useCase: GetItemCallUseCase
) : BaseViewModel() {
    val mutableListCallLiveData = MutableLiveData<List<ToCallResponse>>()
    fun getListItemsCall() {
        loadingData.postValue(true)
        viewModelScope.safeLaunch {
            when (val result = useCase.getCallItems()) {
                is ResultWrapper.Success -> {
                    mutableListCallLiveData.postValue(result.data)
                    loadingData.postValue(false)
                }
                else -> {
                    loadingData.postValue(false)
                }
            }
        }
    }
}