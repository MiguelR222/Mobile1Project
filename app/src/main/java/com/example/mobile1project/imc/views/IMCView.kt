package com.example.mobile1project.imc.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.mobile1project.R
import com.example.mobile1project.imc.viewmodels.IMCViewModel

@Composable
fun IMCView(viewModel: IMCViewModel = viewModel()) {
    val context = LocalContext.current
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    val imc by viewModel.imc
    val status by viewModel.status

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text(text = context.getString(R.string.enter_weight)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = height,
            onValueChange = { height = it },
            label = { Text(text = context.getString(R.string.enter_height)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val weightFloat = weight.toFloatOrNull()
                val heightFloat = height.toFloatOrNull()

                if (weightFloat != null && heightFloat != null && heightFloat > 0) {
                    viewModel.calculateIMC(weightFloat, heightFloat, context::getString)
                }
            },
            enabled = weight.isNotEmpty() && height.isNotEmpty()
        ) {
            Text(text = context.getString(R.string.calculate))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = String.format("%.2f", imc),
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Text(
                    text = status,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }
}

