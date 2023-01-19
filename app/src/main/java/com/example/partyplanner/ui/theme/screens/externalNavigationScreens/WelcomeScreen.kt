package com.example.partyplanner.ui.theme.screens.externalNavigationScreens

import android.util.Log
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
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun WelcomeText(text: String) {
    Text(
        text = text,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 38.sp, color = Color.Black
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
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
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
        StandardButton(
            output = "Login",
            lambda = { navController.navigate(Destination.LoginScreen.route) }
        )
        StandardButton(
            output = "Opret Bruger",
            lambda = { navController.navigate(Destination.MakeUserScreen.route) })
        StandardButton(
            output = "Test",
            lambda = {
                Firebase.auth.signInWithEmailAndPassword("userfinal2exam@mail.com", "userfinal2")
                    .addOnSuccessListener {
                        if (Firebase.auth.currentUser != null) {
                            navController.navigate(Destination.OnMainAppStartScreen.route)
                        }
                    }.addOnFailureListener {
                        Log.v(
                            "LOGIN_SERVICE",
                            "FAILED TO LOG IN WHICH IS FIREBASE'S FAULT NOT ANYONE ELSE. " +
                                    "SINCE IT IS JUST AN ABSTRACTED METHOD THAT IS BEING CALLED WITHOUT ANY IMPLEMENTATION FROM OUR SIDE" +
                                    "IT MIGHT BE THE WRONG CODE BUT PROBABLY NOT. IT IS IMPOSSIBLE TO TELL SINCE THERE IS NO ERROR HANDLING "
                        )
                    }


            })
    }

}



