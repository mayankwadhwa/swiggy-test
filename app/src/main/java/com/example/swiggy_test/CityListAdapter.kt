package com.example.swiggy_test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swiggy_test.databinding.ItemCityBinding

class CityListAdapter(val onCitySelected: (City) -> Unit): ListAdapter<City, CityListAdapter.CityViewHolder>(City.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = getItem(position)
        holder.bind(city)
    }

    inner class CityViewHolder(val binding: ItemCityBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(city: City) {
            val cityText = "${city.administrativeArea.englishName}, ${city.country.englishName}"
            binding.textView.text = cityText
            binding.textView.setOnClickListener {
                onCitySelected(city)
            }
        }
    }
}