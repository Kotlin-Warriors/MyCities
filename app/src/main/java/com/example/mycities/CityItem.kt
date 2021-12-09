package com.example.mycities


import com.google.gson.annotations.SerializedName

data class CityItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("long_description")
    val longDescription: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)