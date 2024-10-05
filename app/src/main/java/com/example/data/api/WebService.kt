package com.example.data.api

import com.example.data.models.auth.AuthResponse
import com.example.data.models.restaurant.RestaurantDTo
import com.example.data.models.restaurant.RestaurantResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface WebService {

    @POST("/api/login")
    @FormUrlEncoded
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): AuthResponse

    @GET("/api/restaurants")
    suspend fun getAllRestaurants(): RestaurantResponse<RestaurantDTo>
}