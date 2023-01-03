package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.google.firebase.auth.FirebaseAuth

@Composable
fun FBOpretBruger(navController: NavController) {
    val auth = FirebaseAuth.getInstance()
    var forNavn by remember { mutableStateOf(TextFieldValue("")) }
    var efterNavn by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var kodeord by remember { mutableStateOf(TextFieldValue("")) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(
            value = forNavn,
            onValueChange = { forNavn = it },
            label = { Text("Fornavn") }
        )
        TextField(
            value = efterNavn,
            onValueChange = { efterNavn = it },
            label = { Text("Efternavn") }
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        TextField(
            value = kodeord,
            onValueChange = { kodeord = it },
            label = { Text("Kodeord") }
        )
        Button(onClick = {
            auth.createUserWithEmailAndPassword(email.text.toString(), kodeord.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // User has been successfully created
                    } else {
                        // There was an error creating the user
                    }
                }
        }) {
            Text("Opret Bruger")
        }
    }
}