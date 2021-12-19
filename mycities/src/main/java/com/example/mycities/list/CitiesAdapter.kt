package com.example.mycities.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycities.R
import com.example.mycities.model.CityItem
import com.squareup.picasso.Picasso

class CitiesAdapter(
    private val citiesList: ArrayList<CityItem>,
    private val onItemClicked: (CityItem) -> Unit
) : RecyclerView.Adapter<CitiesAdapter.CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_city_item, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = citiesList[position]
        holder.itemView.setOnClickListener { onItemClicked(citiesList[position]) }
        holder.bind(city)
    }

    override fun getItemCount(): Int = citiesList.size

    fun appendItems(newItems: ArrayList<CityItem>) {
        citiesList.clear()
        citiesList.addAll(newItems)
        notifyDataSetChanged()
    }

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private var descriptionTextView: TextView =
            itemView.findViewById(R.id.short_description_text_view)
        private var ratingTextView: TextView = itemView.findViewById(R.id.rating_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(city: CityItem) {
            nameTextView.text = city.name
            descriptionTextView.text = city.description
            ratingTextView.text = city.rating
            Picasso.get().load(city.urlPicture).into(pictureImageView)
        }
    }
}