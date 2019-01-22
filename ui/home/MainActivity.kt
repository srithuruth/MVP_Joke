package com.example.kathishan.mvp_joke.ui.home

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.support.v7.appcompat.R.id.message
import android.widget.Toast
import com.example.kathishan.mvp_joke.R
import com.example.kathishan.mvp_joke.model.APIData
import com.example.kathishan.mvp_joke.network.APIService
import com.example.kathishan.mvp_joke.network.BASE_URL
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {

    //private val view: HomeContract.View) : HomeContract.Presenter
    @Inject
    lateinit var jokeService: APIService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        (application as App).getComponent().inject(this)

        val homePresenter: HomeContract.Presenter = HomePresenter(jokeService, this)

        btnDisplay.setOnClickListener {

            homePresenter.getDetails()

            jokeService.getDetails().enqueue(object : Callback<APIData> {
                override fun onFailure(call: Call<APIData>, throwable: Throwable) {
                    throwable.printStackTrace()
                }

                override fun onResponse(call: Call<APIData>, response: Response<APIData>) {
                    if (response.isSuccessful) {
                        val jokeDisplay = response.body()
                        tvJoke.text = jokeDisplay?.value
                    }
                }
            })
        }
    }

    override fun showResults(results: APIData) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    @SuppressLint("ResourceType")
    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}



/*           jokeService.getDetails().enqueue( object : Callback<APIData>{
               override fun onFailure(call: Call<APIData>, t: Throwable) {

               }

               override fun onResponse(call: Call<APIData>, response: Response<APIData>) {

                       if (response.isSuccessful) {
                           view.showResults(response.body())
                       } else {
                           view.showError("An unknown error occurred")
                       }
                   }


           })*/