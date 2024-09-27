package com.example.trainingapp1.network.data.repository

import com.example.trainingapp1.network.data.remote.ApiService
import com.example.trainingapp1.network.data.remote.request.LoginRequest
import com.example.trainingapp1.network.data.remote.request.SignUpRequest
import com.example.trainingapp1.network.data.remote.response.LoginResponse
import com.example.trainingapp1.network.data.remote.response.SignUpResponse
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun signUp(signUpRequest: SignUpRequest): Response<SignUpResponse> {
        return apiService.signUp(signUpRequest)
    }

    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return apiService.login(loginRequest)
    }
}