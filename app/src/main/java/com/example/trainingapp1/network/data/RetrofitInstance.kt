package com.example.trainingapp1.network.data

import com.example.trainingapp1.network.model.LoginApiService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.create

object RetrofitInstance {

    private const val BASE_URL = "https://android-training.appssquare.com/api"

    private val retrofit: Retrofit

    init {


        val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        retrofit = builder.client(okHttpClient).build()
    }

    fun getLoginService() : LoginApiService {
        return retrofit.create(LoginApiService::class.java)
    }
}
