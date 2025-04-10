package com.example.mobile1project.temperature.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.mobile1project.R
import com.example.mobile1project.temperature.viewmodels.TemperatureViewModel

@Composable
fun TemperatureView(viewModel: TemperatureViewModel = viewModel()) {
    val context = LocalContext.current
    var celcius by remember { mutableStateOf("") }
    val result by viewModel.result

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = context.getString(R.string.temp_convert),
            fontSize = 22.sp
                )
        Image(
            painter = painterResource(id = R.drawable.thermometer),
            contentDescription = stringResource(R.string.temp_image_desc),
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )
        TextField(
            value = celcius,
            onValueChange = { celcius = it },
            label = { Text(text = context.getString(R.string.temp_input)) },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                val celciusFloat = celcius.toFloatOrNull()

                if (celciusFloat != null) {
                    viewModel.calculateFarenheit(celciusFloat)
                }
            },
            enabled = celcius.isNotEmpty()
        ) {
            Text(text = context.getString(R.string.calculate))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = String.format("%.2f", result),
                    fontSize = 24.sp,
                    color = Color.Black
                )
                Text(
                    text = "°F",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }
}