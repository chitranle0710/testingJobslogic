package com.example.apptestingmvvm.repository

import com.example.apptestingmvvm.data.entity.Animal
import com.example.apptestingmvvm.network.NetworkResult

interface GetListAnimal {
    suspend fun getAnimalList(id: String?): NetworkResult<List<Animal>>
}