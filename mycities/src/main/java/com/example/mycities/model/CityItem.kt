package com.example.mycities.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CityItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("interest_places")
    val interestPlaces: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("long_description")
    val longDescription: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("temperature")
    val temperature: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("latitude")
    val latitude: Float,
    @SerializedName("length")
    val length: Float
): Serializable