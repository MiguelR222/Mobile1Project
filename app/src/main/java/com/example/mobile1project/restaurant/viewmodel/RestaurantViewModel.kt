package com.example.mobile1project.restaurant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile1project.restaurant.model.Restaurant
import com.example.mobile1project.restaurant.network.RestaurantApiService
import com.example.mobile1project.restaurant.repository.RestaurantRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RestaurantViewModel : ViewModel() {

    private val apiService = RestaurantApiService.create()
    private val repository = RestaurantRepository(apiService)

    private val _Restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val Restaurants = _Restaurants.asStateFlow()

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        viewModelScope.launch {
            try {
                _Restaurants.value = repository.fetchRestaurants()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
