package com.example.mobile1project.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.mobile1project.final.FinalView
import com.example.mobile1project.ids.IdsView
import com.example.mobile1project.firstpartial.FirstPartialView
import com.example.mobile1project.imc.views.IMCView
import com.example.mobile1project.location.view.LocationListScreen
import com.example.mobile1project.restaurant.model.Restaurant
import com.example.mobile1project.restaurant.viewmodel.RestaurantViewModel
import com.example.mobile1project.restaurant.views.RestaurantDetailScreen
import com.example.mobile1project.restaurant.views.RestaurantListScreen
import com.example.mobile1project.secondpartial.SecondPartialView
import com.example.mobile1project.studentlist.view.StudentList
import com.example.mobile1project.studentlist.viewmodel.StudentViewModel
import com.example.mobile1project.sum.views.SumView
import com.example.mobile1project.temperature.views.TemperatureView
import com.example.mobile1project.thirdpartial.ThirdPartialView
import com.example.mobile1project.thirdpartialexam.view.StudentListView

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun TabBarNavigationView(navController: NavHostController = rememberNavController()) {
    val items = listOf(
        ScreenNavigation.Ids,
        ScreenNavigation.FirstPartial,
        ScreenNavigation.SecondPartial,
        ScreenNavigation.ThirdPartial,
        ScreenNavigation.Final
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(imageVector = screen.icon, contentDescription = stringResource(id = screen.label ) ) },
                        label = { Text(stringResource(id = screen.label )) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route)
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenNavigation.Ids.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenNavigation.Ids.route) { IdsView(navController) }
            composable(ScreenNavigation.FirstPartial.route) { FirstPartialView() }
            composable(ScreenNavigation.SecondPartial.route) { SecondPartialView() }
            composable(ScreenNavigation.ThirdPartial.route) { ThirdPartialView(navController) }
            composable(ScreenNavigation.Final.route) { FinalView(navController) }
            composable(ScreenNavigation.IMC.route) { IMCView() }
            composable(ScreenNavigation.Sum.route) { SumView() }
            composable(ScreenNavigation.Temperature.route) { TemperatureView() }
            composable(ScreenNavigation.StudentList.route) { StudentList(StudentViewModel()) }
            composable(ScreenNavigation.StudentListApi.route) { StudentListView()}
            composable(ScreenNavigation.Location.route) { LocationListScreen() }
            composable(ScreenNavigation.RestaurantList.route) { RestaurantListScreen(RestaurantViewModel(), navController) }
            composable(ScreenNavigation.RestaurantDetail.route) {
                val restaurant = navController.previousBackStackEntry?.savedStateHandle?.get<Restaurant>("restaurant")
                restaurant?.let { RestaurantDetailScreen(it) }
            }

        }
    }
}