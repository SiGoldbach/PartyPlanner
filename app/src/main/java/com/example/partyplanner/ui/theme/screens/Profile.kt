package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.R
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun Profile(internalNavController: NavController, externalNavController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.profilepicexample),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(10.dp))                       // clip to the circle shape
                .border(2.dp, color = dustyRose, RoundedCornerShape(10.dp))
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth(0.8F)
                .fillMaxHeight(0.8F),
            elevation = 10.dp,
            backgroundColor = beige,
            border = BorderStroke(color = dustyRose, width = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "name: MyName",
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp, color = Color.Black
                )
                Text(
                    text = "mail: myMail@gmail.com",
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp, color = Color.Black
                )
                Text(
                    text = "Profile description:",
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp, color = Color.Black
                )

                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis interdum dignissim est, sit amet molestie leo feugiat ut. Vestibulum quis felis sem. Donec ornare odio a luctus sodales. Fusce ipsum libero, efficitur in iaculis et, aliquam sit amet leo. Nullam in efficitur justo, sit amet volutpat lacus. Maecenas porta mi et ex molestie, sit amet placerat nunc commodo. Pellentesque sed lobortis erat. Maecenas faucibus ante interdum, pulvinar nunc consectetur, euismod mi.",
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp, color = Color.Black
                )


            }


        }
        Button(
            onClick = { externalNavController.navigate(Destination.Welcome.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)
        ) {
            Text(text = "Log ud")

        }


    }

}