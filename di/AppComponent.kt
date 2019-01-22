package com.example.kathishan.mvp_joke.di

import com.example.kathishan.mvp_joke.ui.home.MainActivity
import dagger.Component
import javax.inject.Singleton


@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}