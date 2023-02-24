package com.example.apptestingmvvm.data.entity

import com.google.gson.annotations.SerializedName

data class Animal(
    @SerializedName("name") val name: String? = null
)