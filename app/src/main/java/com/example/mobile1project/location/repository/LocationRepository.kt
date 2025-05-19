package com.example.mobile1project.location.repository

import com.example.mobile1project.location.model.Location
import com.example.mobile1project.location.network.LocationApiService

class LocationRepository(private val apiService: LocationApiService) {
    suspend fun fetchLocations(): List<Location> {
        return apiService.getLocations()
    }
}