package com.example.retrofitapp.api

import com.example.retrofitapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyIntercepter())
    }.build()

    private  val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}