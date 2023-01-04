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
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.OpretBrugerViewmodel
import com.google.firebase.auth.FirebaseAuth

//Import and use topbar


@Composable
fun OpretBruger(
    navController: NavController,
    viewModel: OpretBrugerViewmodel = OpretBrugerViewmodel()
) {

    var forNavn by remember { mutableStateOf(TextFieldValue("")) }
    var efterNavn by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var kodeord by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        Box {
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
            value = forNavn,
            label = { Text(text = "Fornavn", color = dustyRose) },
            onValueChange = { forNavn = it }
        )
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = efterNavn,
            label = { Text(text = "Efternavn", color = dustyRose) },
            onValueChange = { efterNavn = it }
        )
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = email,
            label = { Text(text = "E-mail", color = dustyRose) },
            onValueChange = { email = it }
        )
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = kodeord,
            label = { Text(text = "Kodeord", color = dustyRose) },
            onValueChange = { kodeord = it }
        )

        Spacer(modifier = Modifier.height(50.dp))
        //MAKING A STANDARD BUTTON FOR TRYING THE LOGIN
        Button(onClick = {
            OpretBrugerViewmodel().putCredentialsAndCreateUser(
                forNavn = forNavn.text,
                efterNavn = efterNavn.text,
                email = email.text,
                kodeord = kodeord.text
            )
            //Navigation skal lige fixes
            navController.navigate(Destination.ComingEvents.route)
        }) {
            Text("Opret Bruger")
        }

    }
    // Skal være en "tilbage" button.
    Box(contentAlignment = Alignment.Center) {
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
