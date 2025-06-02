package com.example.mobile1project.restaurant.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.mobile1project.R
import com.example.mobile1project.restaurant.model.Restaurant
import com.example.mobile1project.restaurant.viewmodel.RestaurantViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailScreen(restaurant: Restaurant) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = getDrawableId(restaurant.imgName.lowercase())),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            cameraPositionState = rememberCameraPositionState() {
                position = CameraPosition.fromLatLngZoom(
                    LatLng(restaurant.latitude, restaurant.longitude), 15f
                )
            }
        ) {
            Marker(
                state = MarkerState(position = LatLng(restaurant.latitude, restaurant.longitude)),
                title = restaurant.name
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text =restaurant.name)
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {

            Button(onClick = {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${restaurant.phone}")
                }
                context.startActivity(intent)
            }) {
                Text(stringResource(R.string.call))
            }

            Button(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(restaurant.webSite))
                context.startActivity(intent)
            }) {
                Text(stringResource(R.string.visit_site))
            }
        }
    }
}
