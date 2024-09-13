package com.example.trainingapp1.network.dto

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("token") val accessTokenVerify: String
)
