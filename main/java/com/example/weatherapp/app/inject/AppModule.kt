package com.example.weatherapp.app.inject

import android.app.Application
import android.content.Context
import com.example.weatherapp.network.ApiInterface
import com.example.weatherapp.view.MainActivity
import dagger.Binds
import dagger.Provides
import javax.inject.Singleton

abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context

    abstract fun mainActivityInjector(): MainActivity

    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideApiService() : ApiInterface {
        }
    }
}
