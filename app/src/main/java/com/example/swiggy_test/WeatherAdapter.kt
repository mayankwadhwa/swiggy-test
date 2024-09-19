package com.example.swiggy_test

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.swiggy_test.databinding.ItemWeatherBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class WeatherAdapter : ListAdapter<DailyForecast, WeatherAdapter.ViewHolder>(DailyForecast.DIFF_CALLBACK) {
    inner class ViewHolder(val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NewApi")
        fun bind(dailyForecast: DailyForecast) {
            binding.date.text = LocalDate.ofEpochDay(dailyForecast.epochDate).format(DateTimeFormatter.ofPattern("dd MMM"))
            binding.temperatureMin.text = "Min: " + dailyForecast.temperature.minimum.value.toString() + "°F"
            binding.temperatureMax.text = "Max: " + dailyForecast.temperature.maximum.value.toString() + "°F"
            binding.source.text = "Source: " + dailyForecast.sources.joinToString()
            // append 0 if less than 10
            val dayIconUrl =
                "https://developer.accuweather.com/sites/default/files/%02d-s.png".format(dailyForecast.day.icon)
            val nightIconUrl =
                "https://developer.accuweather.com/sites/default/files/%02d-s.png".format(dailyForecast.night.icon)
            Glide.with(binding.root.context).load(dayIconUrl).into(binding.dayImage)
            Glide.with(binding.root.context).load(nightIconUrl).into(binding.nightImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}