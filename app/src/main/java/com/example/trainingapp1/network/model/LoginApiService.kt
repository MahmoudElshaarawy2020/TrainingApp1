package com.example.trainingapp1.network.model


import com.example.trainingapp1.network.dto.LoginDto
import com.example.trainingapp1.network.dto.TokenDto
import com.example.trainingapp1.network.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApiService {

    @POST("/login")
    suspend fun getLogin(@Body loginDto: LoginDto) : Response<TokenDto>

}











data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(val token: String)
