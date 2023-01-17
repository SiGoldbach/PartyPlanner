package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.R
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp

@Composable
fun ProfileEditScreen(
    internalNavController: NavController,
    viewModelOnApp: ViewModelOnApp
) {
    val appState by viewModelOnApp.uiState.collectAsState()
    var name by remember { mutableStateOf(TextFieldValue(appState.user.name)) }
    var surname by remember { mutableStateOf(TextFieldValue(appState.user.surname)) }

    var profilBeskrivelse by remember { mutableStateOf(TextFieldValue(appState.user.description)) }
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
                /* Text(
                     text = appState.user.name + " " + appState.user.surname,
                     fontStyle = FontStyle.Normal,
                     fontSize = 16.sp, color = Color.Black
                 ) */
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
                    value = name,
                    label = { Text(text = "Brugernavn", color = dustyRose) },
                    onValueChange = { name = it },
                    modifier = Modifier.width(350.dp)

                )
                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
                    value = surname,
                    label = { Text(text = "Efternavn", color = dustyRose) },
                    onValueChange = { surname = it },
                    modifier = Modifier.width(350.dp)

                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = appState.user.email,
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp, color = Color.Black
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
                    value = profilBeskrivelse,
                    label = { Text(text = "Profilbeskrivelse", color = dustyRose) },
                    onValueChange = { profilBeskrivelse = it },
                    modifier = Modifier.width(350.dp)

                )
                /*
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
                */
            }

        }
        Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center) {
            Button(
                onClick = {
                    internalNavController.navigate(Destination.Profile.route) {
                        internalNavController.popBackStack()
                        internalNavController.popBackStack()
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)
            ) {
                Text(text = "Afbryd")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    viewModelOnApp.updateUser(name = name.text, surname = surname.text, description = profilBeskrivelse.text)
                    internalNavController.navigate(Destination.Profile.route) {
                        internalNavController.popBackStack()
                        internalNavController.popBackStack()


                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)
            ) {
                Text(text = "Gem")
            }
        }
    }
}