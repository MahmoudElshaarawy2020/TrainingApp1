package com.example.trainingapp1.network.data.repository

import com.example.trainingapp1.network.data.local.AuthPreferences
import com.example.trainingapp1.network.data.remote.ApiService
import com.example.trainingapp1.network.data.remote.request.AuthRequest
import com.example.trainingapp1.network.domain.repository.AuthRepository
import com.example.trainingapp1.util.Resource
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val apiService: ApiService,
    private val preferences: AuthPreferences

) : AuthRepository{
    override suspend fun login(loginRequest: AuthRequest): Resource<Unit> {
        return try {
            val response = apiService.loginUser(loginRequest)
            preferences.saveAuthToken(response.token)
            Resource.Success(Unit)
        }catch (e: IOException){
            Resource.Error("${e.message}")
        }catch (e: HttpException){
            Resource.Error("${e.message}")
        }
    }

    override suspend fun register(registerRequest: AuthRequest): Resource<Unit> {
        return try {
            val response = apiService.registerUser(registerRequest)
            preferences.saveAuthToken(response.token)
            Resource.Success(Unit)
        }catch (e: IOException){
            Resource.Error("${e.message}")
        }catch (e: HttpException){
            Resource.Error("${e.message}")
        }
    }


}