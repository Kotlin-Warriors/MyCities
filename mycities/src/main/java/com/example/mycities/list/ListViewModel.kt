package com.example.mycities.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycities.model.City
import com.example.mycities.model.CityItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel : ViewModel() {

    private val citiesLoad : MutableLiveData<ArrayList<CityItem>> = MutableLiveData()
    val onCitiesLoaded : LiveData<ArrayList<CityItem>> = citiesLoad

    fun loadMockCitiesFromJson(citiesString: InputStream?) {
        val citieString = citiesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        citiesLoad.value = gson.fromJson(citieString, City::class.java)
    }
}