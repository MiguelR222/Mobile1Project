package com.example.mobile1project.sum.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile1project.R
import com.example.mobile1project.sum.viewmodels.SumViewModel

@Composable
fun SumView(viewModel: SumViewModel = viewModel()) {
    val context = LocalContext.current
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    val result by viewModel.result

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text(context.getString(R.string.enter_first_number)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text(context.getString(R.string.enter_second_number)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val num1Int = num1.toIntOrNull()
                val num2Int = num2.toIntOrNull()

                if (num1Int != null && num2Int != null) {
                    viewModel.calculateSum(num1Int, num2Int)
                }
            },
            enabled = num1.isNotEmpty() && num2.isNotEmpty()
        ) {
            Text(context.getString(R.string.calculate))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = result.toString(),
                fontSize = 24.sp,
                color = Color.Black
            )
        }
    }
}

