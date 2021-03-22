package com.example.weatherapp.data

import android.content.Context
import com.example.weatherapp.network.RequestCompleteListener
import com.example.weatherapp.network.ApiInterface
import com.example.weatherapp.network.WeatherResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WeatherDataRepositoryImpl  @Inject constructor(
    private val context: Context,
    private val apiInterface: ApiInterface
) : WeatherDataRepository {
    override suspend fun getWeatherDetails(
        location: LocationModel,
        callback: RequestCompleteListener<WeatherResponseData>
    ) {
        val call: Call<WeatherResponseData> = apiInterface.getCurrentWeather(
            longitude = location.longitude,
            latitude = location.longitude
        )

        call.enqueue(object : Callback<WeatherResponseData> {

            override fun onResponse(
                call: Call<WeatherResponseData>,
                response: Response<WeatherResponseData>
            ) {
                if (response.body() != null)
                    callback.onRequestSuccess(requireNotNull(response.body()))
                else
                    callback.onRequestFailed(response.message())
            }

            override fun onFailure(call: Call<WeatherResponseData>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}