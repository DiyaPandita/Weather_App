package com.example.weatherapp.app.inject

import com.example.weatherapp.app.application.MyApplication
import com.example.weatherapp.view.MainActivity
import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface ApplicationComponent {
        fun inject(application: MyApplication)

        fun inject(mainActivity: MainActivity)

    }