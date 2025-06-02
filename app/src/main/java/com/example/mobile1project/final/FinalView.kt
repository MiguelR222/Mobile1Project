package com.example.mobile1project.final

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.mobile1project.R
import com.example.mobile1project.navigation.ScreenNavigation

@Composable
fun FinalView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Final",
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { navController.navigate(ScreenNavigation.RestaurantList.route) },
            modifier = Modifier.fillMaxWidth()

        ) {
            Icon(imageVector = ScreenNavigation.RestaurantList.icon, contentDescription = stringResource(id = ScreenNavigation.RestaurantList.label) )
            Spacer(modifier = Modifier.size(8.dp))
            Text("${stringResource(R.string.go_to)} ${stringResource(id = ScreenNavigation.RestaurantList.label)}")
        }
    }
}