package com.example.trainingapp1.network.domain.repository

import com.example.trainingapp1.network.data.remote.request.AuthRequest
import com.example.trainingapp1.network.data.remote.response.AuthResponse
import com.example.trainingapp1.network.data.remote.response.RegisterResponse
import com.example.trainingapp1.util.Resource
import retrofit2.Response

interface AuthRepository {
    suspend fun login(loginRequest: AuthRequest): Resource<Unit>
    suspend fun register(registerRequest: AuthRequest):Resource<Unit>
}