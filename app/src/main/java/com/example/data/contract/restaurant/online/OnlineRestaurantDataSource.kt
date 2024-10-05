package com.example.data.contract.restaurant.online

import com.example.domain.model.restaurant.Restaurant

interface OnlineRestaurantDataSource {

    suspend fun getAllRestaurant(): List<Restaurant>
}