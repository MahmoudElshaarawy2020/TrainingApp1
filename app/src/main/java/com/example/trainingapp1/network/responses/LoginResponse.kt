package com.example.trainingapp1.network.responses

data class LoginResponse(
    val data: Data,
    val message: String,
    val status: Boolean,
    val token: String
)