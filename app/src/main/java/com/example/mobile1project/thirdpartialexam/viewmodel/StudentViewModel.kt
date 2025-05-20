package com.example.mobile1project.thirdpartialexam.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile1project.thirdpartialexam.model.Student
import com.example.mobile1project.thirdpartialexam.network.StudentApiService
import com.example.mobile1project.thirdpartialexam.repository.StudentRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import okio.IOException
import retrofit2.HttpException

class StudentViewModel : ViewModel() {

    private val apiService = StudentApiService.create()
    private val repository = StudentRepository(apiService)
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()

    private val _students = MutableStateFlow<List<Student>>(emptyList())
    val students = _students.asStateFlow()

    init {
        loadStudents()
    }

    private fun loadStudents() {
        viewModelScope.launch {
            try {
                _students.value = repository.fetchStudents()
            } catch (e: HttpException) {
                _errorMessage.value = when (e.code()) {
                    404 -> Log.d("Error 404", "Error 404 no encontrado").toString()
                    400 -> Log.d("Error 500", "Error 500 error servidor").toString()
                    else -> "Error HTTP: ${e.message()}"

                }

            } catch (e:IOException) {
                _errorMessage.value = "Sin conexión a internet"
            }

        }
    }
}
