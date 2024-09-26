package com.example.trainingapp1.network.data.remote.response

import com.example.trainingapp1.network.data.local.LoginData
import com.google.gson.annotations.SerializedName

data class AuthResponse(

    @SerializedName("token")
    val token : String,

)
