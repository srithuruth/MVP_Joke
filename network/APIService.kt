package com.example.kathishan.mvp_joke.network


import com.example.kathishan.mvp_joke.model.APIData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

   /*@GET("jokes/random")
    fun getDetails(@Path("icon_url") icon_url: String,
                   @Path("id") id: String,
                   @Path("url") url: String,
                   @Path("value") value: String): Call<APIData>*/

    @GET(API_ENDPOINT)
    fun getDetails(): Call<APIData>
}




