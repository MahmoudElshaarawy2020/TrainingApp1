package com.example.data.repo.restaurant

import com.example.domain.contract.restaurant.GetRestaurantRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DI {

    @Binds
    abstract fun bindRestaurantRepository(
        getRestaurantRepositoryImpl: GetRestaurantRepositoryImpl
    ): GetRestaurantRepository
}