package com.example.apptestingmvvm.data.entity

import com.google.gson.annotations.SerializedName

data class ToBuyResponse(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("price") val price: Int? = null,
    @SerializedName("quantity") val quantity: Int? = null,
    @SerializedName("type") val type: Int? = null
)