package com.example.mycities.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycities.R
import com.example.mycities.detalle.DetalleActivity
import com.example.mycities.model.City
import com.example.mycities.model.CityItem
import com.google.gson.Gson

class ListCitiesActivity : AppCompatActivity() {

    private lateinit var listCities: ArrayList<CityItem>
    private lateinit var citiesAdapter: CitiesAdapter
    private lateinit var citiesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cities)

        citiesRecyclerView = findViewById(R.id.cities_recycler_view)

        //listCities = createMockCities()
        listCities = loadMockCitiesFromJson()

        citiesAdapter = CitiesAdapter(listCities, onItemClicked = { onCityClicked(it) })

        citiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = citiesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onCityClicked(city: CityItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("city", city)
        startActivity(intent)
    }

    private fun loadMockCitiesFromJson(): ArrayList<CityItem> {

        val citiesString: String =
            applicationContext.assets.open("mock_cities.json").bufferedReader()
                .use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(citiesString, City::class.java)

        return data
    }
}