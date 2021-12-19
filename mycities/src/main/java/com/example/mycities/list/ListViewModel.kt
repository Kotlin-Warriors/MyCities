package com.example.mycities.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycities.data.CitiesRepository
import com.example.mycities.model.City
import com.example.mycities.model.CityItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private val citiesLoad : MutableLiveData<ArrayList<CityItem>> = MutableLiveData()
    val onCitiesLoaded : LiveData<ArrayList<CityItem>> = citiesLoad

    private val repository = CitiesRepository()

    fun getCitiesFromServer() {
        GlobalScope.launch(Dispatchers.IO) {
            citiesLoad.postValue(repository.getCities())
        }
    }

    fun loadMockCitiesFromJson(citiesString: InputStream?) {
        val citieString = citiesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        citiesLoad.value = gson.fromJson(citieString, City::class.java)
    }
}