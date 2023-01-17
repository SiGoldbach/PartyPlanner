package com.example.partyplanner.ui.theme.screens.reuseables

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.partyplanner.R
import com.example.partyplanner.ui.theme.dustyRose

/**
 * This is a universal Screen used when loading events from the server
 */
@Composable
fun loadingScreen(text: String) {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(2000, easing = LinearEasing), RepeatMode.Restart)
    )

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
            modifier = Modifier
                .rotate(angle)
        )

    }

}

@Composable
fun emptyLoadingScreen(text: String, buttonText: String, lambda: () -> Unit) {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(2000, easing = LinearEasing), RepeatMode.Restart)
    )


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
                modifier = Modifier
                    .rotate(angle)
            )
Spacer(modifier = Modifier.height(20.dp))

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