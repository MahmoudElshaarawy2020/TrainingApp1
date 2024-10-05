package com.example.data.datasource.restaurant.online

import com.example.data.contract.restaurant.online.OnlineRestaurantDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DI {


    @Binds
    abstract fun bindRestaurantDataSource(
        onlineRestaurantDataSourceImpl: OnlineRestaurantDataSourceImpl
    ): OnlineRestaurantDataSource
}