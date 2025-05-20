package com.example.mobile1project.thirdpartialexam.repository

import android.util.Log
import com.example.mobile1project.thirdpartialexam.model.Student
import com.example.mobile1project.thirdpartialexam.network.StudentApiService

class StudentRepository(private val apiService: StudentApiService) {
    suspend fun fetchStudents(): List<Student> {

        return apiService.getStudents()
    }
}