package com.example.swiggy_test

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val apiKeyValue = "v2JTowv5IcMnsZP4F0In2iGMnkwhMgV7"

interface WeatherService {

    @GET("locations/v1/cities/search")
    suspend fun searchCity(@Query("q") cityName: String, @Query("apikey") apiKey: String = apiKeyValue): List<City>

    @GET("/forecasts/v1/daily/5day/{locationKey}")
    suspend fun get5DayWeather(@Path("locationKey") locationKey: Long, @Query("apikey") apiKey: String = apiKeyValue): WeatherResponse
}