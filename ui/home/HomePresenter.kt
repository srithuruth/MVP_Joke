package com.example.kathishan.mvp_joke.ui.home

import com.example.kathishan.mvp_joke.model.APIData
import com.example.kathishan.mvp_joke.network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



 class HomePresenter(

    private val apiService: APIService,
    private val view: HomeContract.View) : HomeContract.Presenter {

        override fun getDetails() {

            apiService.getDetails().enqueue(object : Callback<APIData> {

                override fun onFailure(call: Call<APIData>, t: Throwable) {
                    view.showError("Please try again")
                }

                override fun onResponse(call: Call<APIData>, response: Response<APIData>) {
                    if (response.isSuccessful) {
                        val emptyResponse = APIData("","","","")
                        view.showResults(response.body() ?: emptyResponse)
                    } else {
                        view.showError("An unknown error occured")
                    }
                }
           })
        }
    }

