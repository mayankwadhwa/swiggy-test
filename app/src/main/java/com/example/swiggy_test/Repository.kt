package com.example.swiggy_test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val weatherService: WeatherService) {

    fun searchCity(cityName: String): Flow<List<City>> {
        return flow {
            emit(weatherService.searchCity(cityName))
        }.flowOn(Dispatchers.IO)
    }

    fun get5DayWeather(locationKey: Long): Flow<WeatherResponse> {
        return flow {
            emit(weatherService.get5DayWeather(locationKey))
        }.flowOn(Dispatchers.IO)
    }
}