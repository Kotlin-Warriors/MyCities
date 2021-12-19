package com.example.mycities.data

import com.example.mycities.model.City
import retrofit2.http.GET

interface ApiService {
    @GET("Kotlin-Warriors/MyCities/cities")
    suspend fun getCities(): City
}