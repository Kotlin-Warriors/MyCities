package com.example.mycities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        citiesAdapter = CitiesAdapter(listCities)

        citiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = citiesAdapter
            setHasFixedSize(false)
        }
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