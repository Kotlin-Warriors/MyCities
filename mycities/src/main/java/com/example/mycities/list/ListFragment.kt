package com.example.mycities.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycities.databinding.FragmentListBinding
import com.example.mycities.main.MainActivity
import com.example.mycities.model.City
import com.example.mycities.model.CityItem
import com.google.gson.Gson

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel : ListViewModel
    private lateinit var citiesAdapter: CitiesAdapter
    private var listCities: ArrayList<CityItem> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listViewModel.loadMockCitiesFromJson(context?.assets?.open("mock_cities.json"))

        listViewModel.onCitiesLoaded.observe(viewLifecycleOwner, { result ->
            onCitiesLoadedSubscribe(result)
        })

        citiesAdapter =
            CitiesAdapter(listCities, onItemClicked = { onCityClicked(it) })
        listBinding.citiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = citiesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onCitiesLoadedSubscribe(listCity: ArrayList<CityItem>?) {
        listCity?.let { listCities ->
            citiesAdapter.appendItems(listCities)
        }
    }

    private fun onCityClicked(city: CityItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(city = city))
    }

}