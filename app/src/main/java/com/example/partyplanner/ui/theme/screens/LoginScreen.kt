package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var kodeord by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        Box {
            Text(
                text = "Log ind",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(standardDP))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Black)
                .clip(shape = RectangleShape)
        )
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = email,
            label = { Text(text = "E-mail", color = dustyRose) },
            onValueChange = { email = it })
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = kodeord,
            label = { Text(text = "Kodeord", color = dustyRose) },
            onValueChange = { kodeord = it })

        Spacer(modifier = Modifier.height(50.dp))
        StandardButton(output = "Log på",
            lambda = { navController.navigate(Destination.ComingEvents.route) })
        Spacer(modifier = Modifier.height(standardDP))
        Box {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = beige),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier.size(width = 250.dp, height = 42.dp)

            ) {
                Text(
                    text = "Glemt adgangskode?",
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
        }
    }
}
