package com.example.domain.contract.restaurant

import com.example.domain.common.Resource
import com.example.domain.model.restaurant.Restaurant
import kotlinx.coroutines.flow.Flow

interface GetRestaurantRepository {

    suspend fun getRestaurant(): Flow<Resource<List<Restaurant>>>
}