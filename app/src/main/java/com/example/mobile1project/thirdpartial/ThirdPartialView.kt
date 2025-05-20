package com.example.mobile1project.thirdpartial

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
fun ThirdPartialView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.third_partial),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { navController.navigate(ScreenNavigation.StudentList.route) },
            modifier = Modifier.fillMaxWidth()

        ) {
            Icon(imageVector = ScreenNavigation.StudentList.icon, contentDescription = stringResource(id = ScreenNavigation.StudentList.label) )
            Spacer(modifier = Modifier.size(8.dp))
            Text("${stringResource(R.string.go_to)} ${stringResource(id = ScreenNavigation.StudentList.label)}")
        }
        Button(
            onClick = { navController.navigate(ScreenNavigation.Location.route) },
            modifier = Modifier.fillMaxWidth()

        ) {
            Icon(imageVector = ScreenNavigation.Location.icon, contentDescription = stringResource(id = ScreenNavigation.Location.label) )
            Spacer(modifier = Modifier.size(8.dp))
            Text("${stringResource(R.string.go_to)} ${stringResource(id = ScreenNavigation.Location.label)}")
        }
        Button(
            onClick = { navController.navigate(ScreenNavigation.StudentListApi.route) },
            modifier = Modifier.fillMaxWidth()

        ) {
            Icon(imageVector = ScreenNavigation.StudentListApi.icon, contentDescription = stringResource(id = ScreenNavigation.StudentListApi.label) )
            Spacer(modifier = Modifier.size(8.dp))
            Text("${stringResource(R.string.go_to)} ${stringResource(id = ScreenNavigation.StudentListApi.label)}")
        }
    }
}