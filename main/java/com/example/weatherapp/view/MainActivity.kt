package com.example.weatherapp.view

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.viewModel.WeatherDDataViewModelFactory
import com.example.weatherapp.viewModel.WeatherInfoViewModel
import com.hellohasan.weatherappmvvmdagger.features.weather_info_show.model.data_class.WeatherData
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: WeatherDDataViewModelFactory
    private lateinit var viewModel: WeatherInfoViewModel
    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this, factory).get(WeatherInfoViewModel::class.java)

        setLiveData()
    }

    private fun setLiveData() {
        viewModel.weatherInfoLiveData.observe(this, Observer { weatherData ->
            setWeatherInfo(weatherData)
        })

    }

    private fun setWeatherInfo(weatherData: WeatherData?) {
        viewModel.getWeatherInfo()
    }

    override fun onStart() {
        super.onStart()
        invokeLocationAction()
    }

    private fun invokeLocationAction() {
        when {
            allPermissionsGranted() -> {
                viewModel.fetchLocationLiveData().
                        }
                    }
                )
            }
        }
    }
            private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
                ContextCompat.checkSelfPermission(requireContext(), it) == PackageManager.PERMISSION_GRANTED
            }

    companion object {
        private val REQUIRED_PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }

        }


