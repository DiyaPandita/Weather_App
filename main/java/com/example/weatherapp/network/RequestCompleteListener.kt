package com.example.weatherapp.network

import java.lang.Exception

interface RequestCompleteListener<T> {

    fun onRequestSuccess(data: T)
    fun onRequestFailed(errorMessage: String)
}