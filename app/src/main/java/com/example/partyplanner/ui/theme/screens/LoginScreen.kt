package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun LoginScreen(navController: NavController) {
    var Email by remember { mutableStateOf(TextFieldValue("")) }
    var Kodeord by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        Box() {
            Text(
                text = "Log ind",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp, color = Color.Black
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
            value = Email,
            label = { Text(text = "E-mail", color = dustyRose) },
            onValueChange = { Email = it }
        )
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = Kodeord,
            label = { Text(text = "Kodeord", color = dustyRose) },
            onValueChange = { Kodeord = it }
        )

        Spacer(modifier = Modifier.height(50.dp))
        StandardButton(output = "Log på")
        Spacer(modifier = Modifier.height(standardDP))
        Box() {
            Text(
                text = "Glemt adgangskode?",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp, color = Color.Black
            )
        }
    }
}
