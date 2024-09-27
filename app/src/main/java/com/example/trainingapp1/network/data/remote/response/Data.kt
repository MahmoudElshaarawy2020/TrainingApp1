package com.example.trainingapp1.network.data.remote.response

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)