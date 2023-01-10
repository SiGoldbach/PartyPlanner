package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.example.partyplanner.viewModel.OpretBrugerViewmodel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun FBOpretBruger(
    viewModel: OpretBrugerViewmodel = OpretBrugerViewmodel(), navController: NavController
) {

    val auth = FirebaseAuth.getInstance()
    var firstName by remember { mutableStateOf(TextFieldValue("")) }

    var lastName by remember { mutableStateOf(TextFieldValue("")) }

    var email by remember { mutableStateOf(TextFieldValue("")) }

    var password by remember { mutableStateOf(TextFieldValue("")) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = firstName, onValueChange = { firstName = it }, label = { Text("Fornavn") })
        TextField(value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Efternavn") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = password,
            onValueChange = { password = it },
            label = { Text("Kodeord") }

        )
        Button(onClick = {
            OpretBrugerViewmodel().putCredentialsAndCreateUser(
                forNavn = firstName.text,
                efterNavn = lastName.text,
                email = email.text,
                kodeord = password.text
            )
        }) {
            Text("Opret Bruger")
        }
    }
}