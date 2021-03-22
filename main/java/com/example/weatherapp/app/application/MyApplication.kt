package com.example.weatherapp.app.application

import android.app.Application
import com.example.weatherapp.app.inject.AppModule
import com.example.weatherapp.app.inject.ApplicationComponent


class MyApplication : Application (){
    companion object {
         lateinit var daggerAppComponent: ApplicationComponent
    }


    override fun onCreate() {
        super.onCreate()
        daggerAppComponent = DaggerApplicationComponent.builder().androidModule(AppModule(this)).build()
        daggerAppComponent.inject(this)
    }

}