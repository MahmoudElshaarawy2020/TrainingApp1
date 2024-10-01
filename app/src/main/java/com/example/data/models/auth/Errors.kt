package com.example.data.models.auth

import com.google.gson.annotations.SerializedName

data class Errors(

	@field:SerializedName("email")
	val email: List<String?>? = null
)