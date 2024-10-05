package com.example.data.models.restaurant

import com.example.domain.model.restaurant.Restaurant
import com.google.gson.annotations.SerializedName

data class RestaurantDTo(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("restaurant_lat")
    val restaurantLat: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("restaurant_long")
    val restaurantLong: String? = null,

    @field:SerializedName("products")
    val products: List<ProductDTo?>? = null
) {
    fun toRestaurant(): Restaurant {
        return Restaurant(
            image = image,
            name = name,
            address = address
        )
    }
}