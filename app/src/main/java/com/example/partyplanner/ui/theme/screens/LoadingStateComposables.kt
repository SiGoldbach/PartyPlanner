package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.partyplanner.R
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.dustyRose

/**
 * This is a universal Screen used when loading events from the server
 */
@Composable
fun loadingScreen(text: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        Image(
            painter = painterResource(id = R.drawable.loading_pic),
            contentDescription = stringResource(id = R.string.Coming_events),
            contentScale = ContentScale.Crop,
        )

    }

}

@Composable
fun emptyLoadingScreen(text: String, buttonText: String, lambda: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        Image(
            painter = painterResource(id = R.drawable.tumble_weed_png_removebg_preview),
            contentDescription = stringResource(id = R.string.Coming_events),
            contentScale = ContentScale.Crop,
        )
        FloatingActionButton(
            onClick = { lambda.invoke() },
            backgroundColor = dustyRose,
            contentColor = Color.White,
            modifier = Modifier.size(width = 200.dp, height = 50.dp)
        ) {
            Text(text = buttonText)

        }
    }
}