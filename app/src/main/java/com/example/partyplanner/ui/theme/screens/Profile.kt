package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.partyplanner.R
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun Profile(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.profilepic),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(4.dp, color = dustyRose, CircleShape)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .fillMaxHeight(0.6F)
                .clip(RoundedCornerShape(20.dp))
                .background(dustyRose).padding(10.dp)
        ) {
            Column() {
                StandardText(text = "Sebastian Goldbach")
                StandardText(text = "This is a descriptive text about Sebastian")
            }

        }


    }

}