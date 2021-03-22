package com.example.weatherapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.network.RequestCompleteListener
import com.example.weatherapp.data.LocationModel
import com.example.weatherapp.data.WeatherDataRepository
import com.example.weatherapp.network.WeatherResponseData
import com.hellohasan.weatherappmvvmdagger.features.weather_info_show.model.data_class.WeatherData
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherInfoViewModel @Inject constructor(var repository: WeatherDataRepository) :
    ViewModel() {


    val weatherInfoLiveData = MutableLiveData<WeatherData>()

    @Inject
    lateinit var locationLiveData: LocationModel

    fun fetchLocationLiveData() = locationLiveData
    fun getWeather(location: LocationModel) {
        viewModelScope.launch {
            when (val result = repository.getWeatherDetails(location,object :
                RequestCompleteListener<WeatherResponseData>) {

    }


}
    }