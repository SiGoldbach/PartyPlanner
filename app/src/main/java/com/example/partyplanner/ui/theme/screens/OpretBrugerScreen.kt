package com.example.partyplanner.ui.theme.screens

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun OpretBruger(navController: NavController) {
    var Fornavn by remember { mutableStateOf(TextFieldValue("")) }
    var Efternavn by remember { mutableStateOf(TextFieldValue("")) }
    var Email by remember { mutableStateOf(TextFieldValue("")) }
    var Kodeord by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        Box() {
            Text(
                text = "Opret Bruger",
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
            value = Fornavn,
            label = { Text(text = "Fornavn", color = dustyRose) },
            onValueChange = { Fornavn = it }
        )
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = Efternavn,
            label = { Text(text = "Efternavn", color = dustyRose) },
            onValueChange = { Efternavn = it }
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
        StandardButton(output = "Opret")

        Box() {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = beige),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .size(width = 250.dp, height = 42.dp)

            ) {
                Text(
                    text = "Kan ikke oprette bruger?",
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp, color = Color.Black
                )
            }
        }
    }
    // Skal være en "tilbage" button.
    Box (contentAlignment = Alignment.BottomStart) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
        shape = CircleShape,
        modifier = Modifier
            .size(width = 40.dp, height = 40.dp)
    ) {
        Text(
            text = "<",
            fontStyle = FontStyle.Normal,
            fontSize = 20.sp, color = Color.White
        )
    }
    }
}
