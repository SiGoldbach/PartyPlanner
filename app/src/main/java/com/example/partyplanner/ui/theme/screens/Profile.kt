package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.R
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp

@Composable
fun Profile(
    internalNavController: NavController,
    externalNavController: NavController,
    viewModelOnApp: ViewModelOnApp
) {
    val appState by viewModelOnApp.uiState.collectAsState()
    viewModelOnApp.getProfileInfoAndUpdate()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.profilepicexample),
            contentDescription = stringResource(id = R.string.Profile_Picture),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(10.dp))
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
                    text = appState.user.name + " " + appState.user.surname,
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp, color = Color.Black
                )

                Text(
                    text = appState.user.email,
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp, color = Color.Black
                )

                Text(
                    text = stringResource(id = R.string.Profile_Description),
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp, color = Color.Black
                )

                Text(
                    text = appState.user.description,
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp, color = Color.Black
                )


            }


        }
        Button(
            onClick = {
                viewModelOnApp.signOut()
                externalNavController.navigate(Destination.Welcome.route) {
                    popUpTo(0)
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)
        ) {
            Text(text = "Log ud")

        }
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                Button(
                   onClick = {  internalNavController.navigate(Destination.ProfileEditScreen.route) },
                   colors = ButtonDefaults.buttonColors(backgroundColor = beige),
                    shape = CircleShape,
                    modifier = Modifier.size(width = 69.dp, height = 60.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pencildrawing),
                        contentDescription = null,
                        modifier = Modifier.size(width = 35.dp, height = 35.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }

        }

    }

}