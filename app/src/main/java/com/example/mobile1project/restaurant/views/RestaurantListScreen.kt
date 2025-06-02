package com.example.mobile1project.restaurant.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mobile1project.R
import com.example.mobile1project.navigation.ScreenNavigation
import com.example.mobile1project.restaurant.viewmodel.RestaurantViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantListScreen(viewModel: RestaurantViewModel = viewModel(), navController: NavController) {
    val restaurants = viewModel.Restaurants.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Restaurants List") }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(
                top = innerPadding.calculateTopPadding() + 16.dp,
                start = 16.dp, end = 16.dp, bottom = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(restaurants.value) { restaurant ->
                Card(
                    elevation = CardDefaults.cardElevation(4.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.currentBackStackEntry?.savedStateHandle?.set("restaurant", restaurant)
                            navController.navigate(ScreenNavigation.RestaurantDetail.route)
                        }
                ){
                    Image(
                        painter = painterResource(id = getDrawableId(restaurant.imgName.lowercase())),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {

                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(text = restaurant.name)
                            Row {
                                Text(text = "Rating: ${restaurant.rating}")
                                Icon(imageVector = Icons.Default.Star, contentDescription = "Estrella")
                            }
                            Text(text = "${stringResource(R.string.fee)}: ${restaurant.fee}")
                            Text(text = "${stringResource(R.string.delivery)}: ${restaurant.delivery}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun getDrawableId(imageName: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(imageName, "drawable", context.packageName)
}
