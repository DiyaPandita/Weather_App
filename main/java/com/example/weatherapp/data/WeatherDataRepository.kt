package com.example.weatherapp.data

import com.example.weatherapp.network.RequestCompleteListener
import com.example.weatherapp.network.WeatherResponseData

interface WeatherDataRepository {
    suspend fun getWeatherDetails(location: LocationModel, callback: RequestCompleteListener<WeatherResponseData>)

}