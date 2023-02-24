package com.example.apptestingmvvm.repository

import com.example.apptestingmvvm.data.entity.Animal
import com.example.apptestingmvvm.network.ApiService
import com.example.apptestingmvvm.network.BaseService
import com.example.apptestingmvvm.network.NetworkResult
import javax.inject.Inject

class GetListAnimalImpl @Inject constructor(
    private val apiService: ApiService
) : GetListAnimal, BaseService() {
    override suspend fun getAnimalList(id: String?): NetworkResult<List<Animal>> = handleApi {
        apiService.getList(id)
    }

}