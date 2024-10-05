package com.example.data.models.restaurant

import com.google.gson.annotations.SerializedName

data class RestaurantResponse<T>(

	@field:SerializedName("data")
	val restaurant: List<T?>? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)