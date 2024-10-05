package com.example.data.models.restaurant

import com.google.gson.annotations.SerializedName

data class ProductDTo(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("restaurant_id")
	val restaurantId: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)