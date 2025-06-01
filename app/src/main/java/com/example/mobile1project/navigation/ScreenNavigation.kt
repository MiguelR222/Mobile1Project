package com.example.mobile1project.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.mobile1project.R

sealed class ScreenNavigation(val route: String, @StringRes val label: Int, val icon: ImageVector) {
    object Ids : ScreenNavigation("IdsRoute", R.string.home, Icons.Default.Home)
    object FirstPartial : ScreenNavigation("FirstPartialRoute",R.string.partial_1, Icons.Default.LooksOne)
    object SecondPartial : ScreenNavigation("SecondPartialRoute",R.string.partial_2, Icons.Default.LooksTwo)
    object ThirdPartial : ScreenNavigation("ThirdPartialRoute", R.string.partial_3, Icons.Default.Looks3)
    object IMC : ScreenNavigation("ImcRoute", R.string.bmi , Icons.Default.Scale)
    object Sum : ScreenNavigation("SumRoute", R.string.calculator, Icons.Default.Calculate)
    object Temperature : ScreenNavigation("TemperatureRoute", R.string.temperature, Icons.Default.Thermostat)
    object StudentList : ScreenNavigation("StudentListRoute", R.string.student_list, Icons.Default.List)
    object StudentListApi : ScreenNavigation("StudentListApiRoute", R.string.student_list_api, Icons.Default.School)
    object Location : ScreenNavigation("LocationRoute", R.string.location, Icons.Default.SportsBaseball )
}
