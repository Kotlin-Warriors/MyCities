package com.example.mycities.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycities.databinding.FragmentListBinding
import com.example.mycities.main.MainActivity
import com.example.mycities.model.City
import com.example.mycities.model.CityItem
import com.google.gson.Gson

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var citiesAdapter: CitiesAdapter
    private lateinit var listCities: ArrayList<CityItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listCities = loadMockCitiesFromJson()
        citiesAdapter =
            CitiesAdapter(listCities, onItemClicked = { onCityClicked(it) })
        listBinding.citiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = citiesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onCityClicked(city: CityItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(city = city))
    }

    private fun loadMockCitiesFromJson(): ArrayList<CityItem> {
        val citiesString: String = context?.assets?.open("mock_cities.json")?.bufferedReader()
            .use { it!!.readText() } //TODO reparar
        val gson = Gson()
        val data = gson.fromJson(citiesString, City::class.java)

        return data
    }

}