package com.example.data.repo.restaurant

import com.example.data.contract.restaurant.online.OnlineRestaurantDataSource
import com.example.data.utils.toFlow
import com.example.domain.common.Resource
import com.example.domain.contract.restaurant.GetRestaurantRepository
import com.example.domain.model.restaurant.Restaurant
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRestaurantRepositoryImpl @Inject constructor(
    private val onlineRestaurantDataSource: OnlineRestaurantDataSource
) : GetRestaurantRepository {
    override suspend fun getRestaurant(): Flow<Resource<List<Restaurant>>> {
        return toFlow {
            onlineRestaurantDataSource.getAllRestaurant()
        }
    }
}