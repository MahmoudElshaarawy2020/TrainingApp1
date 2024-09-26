package com.example.trainingapp1.network.domain.model

import com.example.trainingapp1.network.data.remote.response.RegisterResponse
import com.example.trainingapp1.util.Resource
import retrofit2.Response

data class AuthResult(
    val passwordError: String? = null,
    val emailError: String? = null,
    val result: Resource<Unit>? = null
)