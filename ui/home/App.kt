package com.example.kathishan.mvp_joke.ui.home

import android.app.Application
import com.example.kathishan.mvp_joke.di.AppComponent
import com.example.kathishan.mvp_joke.di.DaggerAppComponent

class App : Application(){

    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build();
    }
    fun getComponent() = appComponent
}
