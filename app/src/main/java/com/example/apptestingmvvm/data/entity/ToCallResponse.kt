package com.example.apptestingmvvm.data.entity

import com.google.gson.annotations.SerializedName

data class ToCallResponse(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("number") val number: String? = null
)