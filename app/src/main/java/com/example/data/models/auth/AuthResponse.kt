package com.example.data.models.auth

import com.google.gson.annotations.SerializedName

data class AuthResponse(

    @field:SerializedName("data")
    val userDto: UserDto? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Boolean? = null,

    @field:SerializedName("token")
    val token: String? = null,

    @field:SerializedName("errors")
    val errors: Errors? = null,


    )