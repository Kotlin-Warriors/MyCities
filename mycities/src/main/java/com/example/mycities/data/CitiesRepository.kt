package com.example.mycities.data

class CitiesRepository {

    suspend fun getCities() = ApiFactory.retrofit.getCities()
}