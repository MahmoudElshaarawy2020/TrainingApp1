package com.example.trainingapp1.network.data.local

import com.google.gson.annotations.SerializedName

data class LoginData(

    @SerializedName("id")
    val id: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String

)
