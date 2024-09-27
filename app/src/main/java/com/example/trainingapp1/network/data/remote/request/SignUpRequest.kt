package com.example.trainingapp1.network.data.remote.request

data class SignUpRequest(
    val name : String,
    val email: String,
    val password: String,
    val city: String
)
