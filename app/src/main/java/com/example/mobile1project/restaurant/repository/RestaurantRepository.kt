package com.example.mobile1project.restaurant.repository

import com.example.mobile1project.restaurant.model.Restaurant
import com.example.mobile1project.restaurant.network.RestaurantApiService

class RestaurantRepository(private val apiService: RestaurantApiService) {
    suspend fun fetchRestaurants(): List<Restaurant> {
        return apiService.getRestaurants()
    }
}