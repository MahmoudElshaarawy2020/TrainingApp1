package com.example.trainingapp1.data

import com.example.trainingapp1.model.LoginApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitInstance {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://android-training.appssquare.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val api: LoginApiService = retrofit.create(LoginApiService::class.java)
}
