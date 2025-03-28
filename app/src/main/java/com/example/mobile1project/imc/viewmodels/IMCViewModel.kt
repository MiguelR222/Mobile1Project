package com.example.mobile1project.imc.viewmodels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class IMCViewModel : ViewModel() {
    private val _imc = mutableStateOf(0f)
    val imc: State<Float> = _imc

    private val _status = mutableStateOf("")
    val status: State<String> = _status

    fun calculateIMC(weight: Float, height: Float, getString: (Int) -> String) {
        if (height > 0) {
            val imcValue = weight / (height * height)
            _imc.value = imcValue

            _status.value = if (imcValue in 19f..24.9f) {
                getString(com.example.mobile1project.R.string.status_ok)
            } else {
                getString(com.example.mobile1project.R.string.status_not_ok)
            }
        }
    }
}
