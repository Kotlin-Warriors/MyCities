package com.example.mycities.detalle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mycities.databinding.ActivityDetalleBinding
import com.example.mycities.model.CityItem
import com.squareup.picasso.Picasso

class DetalleActivity : AppCompatActivity() {
    private lateinit var detalleBinding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val city: CityItem = intent.extras?.getSerializable("city") as CityItem
        with(detalleBinding){
            nameTextView.text = city.name
            txtDescription.text = city.longDescription
            txtLocation.text = city.location
            txtInterest.text = city.interestPlaces
            txtTemperature.text = city.temperature
            Picasso.get().load(city.urlPicture).into(imgPOI)
        }
    }
}