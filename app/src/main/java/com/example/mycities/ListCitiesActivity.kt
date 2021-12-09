package com.example.mycities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListCitiesActivity : AppCompatActivity() {

    private lateinit var listCities : ArrayList<City>
    private lateinit var citiesAdapter: CitiesAdapter
    private lateinit var citiesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cities)

        citiesRecyclerView = findViewById(R.id.cities_recycler_view)

        listCities = createMockCities()

        citiesAdapter = CitiesAdapter(listCities)

        citiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = citiesAdapter
            setHasFixedSize(false)
        }
    }

    private fun createMockCities(): ArrayList<City> {
        return arrayListOf(
            City(
                name = "El Danubio",
                description = "La Reserva Natural el Danubio es en definitiva un Paraíso.",
                rating = "Puntaje 10",
                photoPlaceUrl = "https://conocecolombia.com/wp-content/uploads/2019/10/oaisis-sirena-reserva-danubio-valledel-cauca-colombia.jpg"
            ),
            City(
                name = "Minas de sal de Nemocón",
                description = "Nemocón es un pueblo en Cundinamarca famoso por su gran actividad minera.",
                rating = "Puntaje 9",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/Salt_Mine_Nemocon_Colombia_5743986824-1024x680.jpg"
            ),
            City(
                name = "Parque Nacional Natural El Tuparro",
                description = "El Parque Nacional Natural El Tuparro es una reserva natural de gran extensión.",
                rating = "Puntaje 7",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/DSC05257-1024x683.jpg"
            ),
            City(
                name = "Punta Gallinas",
                description = "Es una experiencia inigualable.",
                rating = "Puntaje 8",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/P1080747.png"
            ),
            City(
                name = "Caño Cristales",
                description = "Ubicado en la sierra de la Macarena en el Meta, se encuentra Caño Cristales.",
                rating = "Puntaje 10",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/cano_cristales.png"
            ),
            City(
                name = "Reserva Río Claro",
                description = "A tres horas de la capital antioqueña se encuentra Río Claro.",
                rating = "Puntaje 7",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/h11-1024x478-1.png"
            ),
            City(
                name = "Cerro Azul",
                description = "A 47 Km de San José del Guaviare está ubicado Cerro Azul.",
                rating = "Puntaje 8",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/15pinturascerroazul-1024x683.jpg"
            ),
            City(
                name = "Desierto de la Tatacoa",
                description = "Estar en el desierto de la Tatacoa es una experiencia inolvidable.",
                rating = "Puntaje 8",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/nva.png"
            ),
            City(
                name = "Puerto Nariño",
                description = "A 75 km de Leticia, está Puerto Nariño.",
                rating = "Puntaje 7",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/puertos_narino.png"
            ),
            City(
                name = "Santuario de las Lajas",
                description = "El Santuario de las Lajas es una iglesia católica ubicada en Ipiales.",
                rating = "Puntaje 8",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/las-lajas.png"
            ),
            City(
                name = "Parque Nacional Natural Utría",
                description = "Una de las experiencias más increíbles para los amantes del ecoturismo.",
                rating = "Puntaje 7",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/ballenas-jorobadas.png"
            ),
            City(
                name = "Parque Natural Los Estoraques",
                description = "Alberga formaciones milenarias que han sido creadas a partir del viento y el agua.",
                rating = "Puntaje 8",
                photoPlaceUrl = "https://www.colombia.co/wp-content/uploads/2017/09/Los_Estoraques_Norte_de_Santander_Colombia_by_Edgar.png"
            )
        )
    }
}