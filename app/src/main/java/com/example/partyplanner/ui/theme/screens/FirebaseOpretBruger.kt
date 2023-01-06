package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.partyplanner.viewModel.OpretBrugerViewmodel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun FBOpretBruger(
    viewModel: OpretBrugerViewmodel = OpretBrugerViewmodel(), navController: NavController
) {

    val auth = FirebaseAuth.getInstance()
    var forNavn by remember { mutableStateOf(TextFieldValue("")) }
    var efterNavn by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var kodeord by remember { mutableStateOf(TextFieldValue("")) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = forNavn, onValueChange = { forNavn = it }, label = { Text("Fornavn") })
        TextField(value = efterNavn,
            onValueChange = { efterNavn = it },
            label = { Text("Efternavn") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = kodeord,
            onValueChange = { kodeord = it },
            label = { Text("Kodeord") }

        )
        Button(onClick = {
            OpretBrugerViewmodel().putCredentialsAndCreateUser(
                forNavn = forNavn.text,
                efterNavn = efterNavn.text,
                email = email.text,
                kodeord = kodeord.text
            )
            navController.navigate("LoginScreen")
        }) {
            Text("Opret Bruger")
        }
    }
}