package com.example.partyplanner.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable fun EventScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
        ) {
            TopScreen()
            Box(
                contentAlignment = Alignment.Center,

                ) {
                Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(5.dp)) {
                    Text(text = "Upcoming events", modifier = Modifier.padding(start = 100.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(1.0F)
                            .height(5.dp)
                            .background(dustyRose)
                            .clip(shape = RectangleShape)
                    )
                }
            }
        }
    }
}