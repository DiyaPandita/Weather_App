package com.example.weatherapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.data.WeatherDataRepository
import javax.inject.Inject

class WeatherDDataViewModelFactory  @Inject constructor(private val arg: WeatherDataRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(WeatherDataRepository::class.java)
            .newInstance(arg)
    }
}