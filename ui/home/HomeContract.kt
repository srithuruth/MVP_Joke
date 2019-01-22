package com.example.kathishan.mvp_joke.ui.home

import com.example.kathishan.mvp_joke.model.APIData

interface HomeContract {

    interface View{
        fun showResults(results: APIData)
        fun showError(message: String)
    }

    interface Presenter{
        fun getDetails()
    }
}