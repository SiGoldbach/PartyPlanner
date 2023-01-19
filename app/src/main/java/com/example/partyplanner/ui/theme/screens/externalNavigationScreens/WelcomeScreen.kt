package com.example.partyplanner.ui.theme.screens.externalNavigationScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.R
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.screens.StandardButton
import com.example.partyplanner.ui.theme.screens.standardDP


@Composable
fun WelcomeText(text: String) {
    Text(
        text = text,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 38.sp,
        color = Color.Black
    )

}


@Composable
fun WelcomeScreenImage() {
    val image = painterResource(id = R.drawable.champagnecelebration)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    WelcomeScreenImage()
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Box(
            contentAlignment = Alignment.Center,

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(9.dp)
                    .fillMaxWidth()
            ) {
                Box {
                    WelcomeText(text = "Velkommen")
                }

                Spacer(modifier = Modifier.height(standardDP))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(Color.Black)
                        .clip(shape = RectangleShape)
                )
            }
        }

        Spacer(modifier = Modifier.height(425.dp))
        StandardButton(output = "Login",
            lambda = { navController.navigate(Destination.LoginScreen.route) })
        StandardButton(output = "Opret Bruger",
            lambda = { navController.navigate(Destination.MakeUserScreen.route) })
        StandardButton(output = "Test", lambda = {
            navController.navigate(Destination.OnMainAppStartScreen.route)
        })
    }

}



