package com.example.swiggy_test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    val coroutinExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable)
        error.value = throwable.message
    }


    val error = MutableLiveData<String>()

    val searchResult = MutableLiveData<List<City>>()

    val weatherForecast = MutableLiveData<List<DailyForecast>>()

    fun searchCity(cityName: String) {
        viewModelScope.launch(coroutinExceptionHandler) {
            if (cityName.length > 3) {
                repository.searchCity(cityName)
                    .collect {
                        searchResult.value = it
                    }
            }
        }
    }

    fun get5DayWeather(locationKey: Long) {
        viewModelScope.launch(coroutinExceptionHandler) {
            repository.get5DayWeather(locationKey)
                .collect {
                    weatherForecast.value = it.dailyForecasts
                }
        }
    }
}