package com.example.data.datasource.restaurant.online

import com.example.data.api.WebService
import com.example.data.contract.restaurant.online.OnlineRestaurantDataSource
import com.example.data.utils.safeApi
import com.example.domain.model.restaurant.Restaurant
import javax.inject.Inject

class OnlineRestaurantDataSourceImpl @Inject constructor(
    private val webService: WebService
) : OnlineRestaurantDataSource {
    override suspend fun getAllRestaurant(): List<Restaurant> {
        return safeApi {
            val list = webService.getAllRestaurants().restaurant?.filterNotNull()!!.map {
                it.toRestaurant()
            }
            list
        }
    }
}