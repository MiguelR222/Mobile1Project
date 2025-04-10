package com.example.mobile1project.ids

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.mobile1project.R
import androidx.compose.ui.unit.dp
import com.example.mobile1project.navigation.ScreenNavigation

@Composable
fun IdsView(navController: NavController) {
    val items= listOf(
        ScreenNavigation.IMC,
        ScreenNavigation.Temperature,
        ScreenNavigation.Sum
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        items.forEach { screen ->
            Button(
                onClick = { navController.navigate(screen.route) },
                modifier = Modifier.fillMaxWidth()

            ) {
                Icon(imageVector = screen.icon, contentDescription = stringResource(id = screen.label) )
                Spacer(modifier = Modifier.size(8.dp))
                Text("${stringResource(R.string.go_to)} ${stringResource(id = screen.label)}")
            }
        }
    }
}