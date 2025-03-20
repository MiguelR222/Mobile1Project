package com.example.mobile1project.sum.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile1project.sum.viewmodels.SumViewModel

@Composable
fun SumView(viewModel: SumViewModel = viewModel()) {
    var num1 by remember { mutableStateOf("0") }
    var num2 by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Enter first number") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Enter second number") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.calculateSum(num1.toIntOrNull() ?: 0, num2.toIntOrNull() ?: 0)
        }) {
            Text("Calculate")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = viewModel.result.value.toString(),
                fontSize = 24.sp,
                color = Color.Black
            )
        }
    }
}
