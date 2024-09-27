package com.example.trainingapp1.network.data.remote

import com.example.trainingapp1.network.data.remote.request.LoginRequest
import com.example.trainingapp1.network.data.remote.request.SignUpRequest
import com.example.trainingapp1.network.data.remote.response.LoginResponse
import com.example.trainingapp1.network.data.remote.response.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
        @POST("/api/sign_up/")
        suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<SignUpResponse>

        @POST("/api/login/")
        suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

}