package com.example.trainingapp1.network.data.remote

import com.example.trainingapp1.network.data.remote.request.AuthRequest
import com.example.trainingapp1.network.data.remote.response.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/login")
    suspend fun loginUser(
        @Body loginRequest: AuthRequest
    ) : AuthResponse


    @POST("api/sign_up")
    suspend fun registerUser(
        @Body registerRequest: AuthRequest
    ) : AuthResponse

}