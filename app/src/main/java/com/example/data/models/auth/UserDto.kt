package com.example.data.models.auth

import com.example.domain.model.login.User
import com.google.gson.annotations.SerializedName

data class UserDto(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("email")
    val email: String? = null
) {
    fun toUser(): User {
        return User(
            id = id,
            email = email,
            name = name
        )
    }
}