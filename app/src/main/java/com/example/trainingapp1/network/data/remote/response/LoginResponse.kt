package com.example.trainingapp1.network.data.remote.response

import com.example.trainingapp1.network.data.models.UserData


data class LoginResponse(
    val success: Boolean,
    val message: String,
    val token: String?,
    val data: UserData?
)
