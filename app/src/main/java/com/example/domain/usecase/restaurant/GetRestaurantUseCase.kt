package com.example.domain.usecase.restaurant

import com.example.domain.common.Resource
import com.example.domain.contract.restaurant.GetRestaurantRepository
import com.example.domain.model.restaurant.Restaurant
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRestaurantUseCase @Inject constructor(
    private val getRestaurantRepository: GetRestaurantRepository
) {

    suspend fun execute(): Flow<Resource<List<Restaurant>>> {
        return getRestaurantRepository.getRestaurant()
    }
}