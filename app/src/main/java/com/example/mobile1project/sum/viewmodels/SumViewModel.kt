package com.example.mobile1project.sum.viewmodels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class SumViewModel : ViewModel() {
    private val _result = mutableStateOf(0)
    val result: State<Int> = _result

    fun calculateSum(num1: Int, num2: Int) {
        _result.value = num1 + num2
    }
}