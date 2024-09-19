package com.example.swiggy_test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.example.swiggy_test.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)

        // Set the content view to the root of the binding class
        setContentView(binding.root)

        binding.searchView.setupWithSearchBar(binding.searchBar)

        binding.searchView.editText.addTextChangedListener {
            viewModel.searchCity(it.toString())
        }

        val cityListAdapter = CityListAdapter { city: City ->
            viewModel.get5DayWeather(city.key.toLong())
            binding.searchView.hide()
        }

        binding.recyclerview.adapter = cityListAdapter

        val weatherAdapter = WeatherAdapter()
        binding.weatherForecastList.adapter = weatherAdapter

        viewModel.weatherForecast.observe(this) {
            weatherAdapter.submitList(it)
        }

        viewModel.get5DayWeather(3033481)


        viewModel.searchResult.observe(this) {
            cityListAdapter.submitList(it)
        }

    }
}