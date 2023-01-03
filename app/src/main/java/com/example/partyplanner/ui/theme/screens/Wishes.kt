package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.partyplanner.R
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.model.Event
import com.example.partyplanner.viewModel.ComingEventsScreenViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.modifier.modifierLocalConsumer
import com.example.partyplanner.naviagion.Destination

@Composable
fun Wishes(navController: NavHostController) {
    val viewModel = ComingEventsScreenViewModel()
    val eventState by viewModel.uiState.collectAsState()
    viewModel.values()


    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxHeight(),
            columns = GridCells.Adaptive(minSize = 160.dp),
            // cells = GridCells.Adaptive(minSize = 160.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            items(eventState.list) { item ->
                WishesComposer(item, navController)
            }
        }
    }
}

/**
 * Here is the standard WishesComposer, now with just a default image of loading.
 * Since no picture has been loaded yet from the viewmodels apis.
 * this is similar to eventComposer
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WishesComposer(event: Event, navController: NavHostController) {
    Card(
        onClick = { navController.navigate(Destination.Event.route) },
        border = BorderStroke(width = 2.dp, color = dustyRose),
        modifier = Modifier
            .size(width = 350.dp, height = 150.dp)
           .padding(5.dp), backgroundColor = beige
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "wish-name")
            Box(modifier = Modifier.fillMaxHeight(1F), Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = R.drawable.loading_picture),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                )

                Row (horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Bottom) {
                        Button(
                            onClick = { navController.navigate(Destination.Event.route) },
                            colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)
                        ) {
                            Text(text = "Gå til")
                        }

                }
            }
        }
    }
}



