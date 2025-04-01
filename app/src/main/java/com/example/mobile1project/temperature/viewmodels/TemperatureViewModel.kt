package com.example.mobile1project.temperature.viewmodels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class TemperatureViewModel : ViewModel() {
    private val _result = mutableStateOf(0f)
    val result: State<Float> = _result


    fun calculateFarenheit(celcius: Float) {
        _result.value =( celcius*9/5)+32
    }
}
