package com.example.mobile1project.restaurant.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    val name: String,
    val rating: String,
    val fee: String,
    val delivery: String,
    val imgName: String,
    val phone: String,
    val webSite: String,
    val latitude: Double,
    val longitude: Double
) : Parcelable
