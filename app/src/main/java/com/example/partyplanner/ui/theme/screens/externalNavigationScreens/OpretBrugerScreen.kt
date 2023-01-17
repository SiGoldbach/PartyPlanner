package com.example.partyplanner.ui.theme.screens.externalNavigationScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.ui.theme.screens.standardDP
import com.example.partyplanner.viewModel.OpretBrugerViewmodel

//Passord visibility from video
// https://www.google.com/search?q=making+password+hidden+compose&sxsrf=AJOqlzXVKGa8wXyv4vyAV-DwT7TR5Ozamw%3A1673903286638&ei=trzFY4rIJuesxc8PkKKUkAU&ved=0ahUKEwiK-6bW_8z8AhVnVvEDHRARBVIQ4dUDCA8&uact=5&oq=making+password+hidden+compose&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAzIFCCEQoAEyBQghEKABMgUIIRCgAToHCCMQ6gIQJzoECCMQJzoECC4QJzoGCCMQJxATOggIABCABBCxAzoICC4QsQMQgwE6CwgAEIAEELEDEIMBOg4ILhCABBCxAxDHARDRAzoFCAAQgAQ6BAgAEEM6BwguENQCEEM6DgguEIAEELEDEIMBENQCOgsILhCABBCxAxCDAToFCC4QgAQ6CAgAEIAEEMsBOggILhCABBDLAToGCAAQHhANOggIABAeEA8QDToGCAAQFhAeOggIABAWEB4QDzoECCEQFToICCEQFhAeEB06CgghEBYQHhAPEB1KBAhBGABKBAhGGABQvARYiCxgmS1oAXABeACAAWyIAZUQkgEEMjguMpgBAKABAbABCsABAQ&sclient=gws-wiz-serp#fpstate=ive&vld=cid:12c764d6,vid:eNAhOqF83Kg
@Composable
fun OpretBruger(
    navController: NavController,
    viewModel: OpretBrugerViewmodel = OpretBrugerViewmodel(),
) {

    var forNavn by remember { mutableStateOf(TextFieldValue("")) }
    var efterNavn by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var kodeord by remember { mutableStateOf(TextFieldValue("")) }

    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) {
        painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
    } else {
        painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        Box {
            Text(
                text = "Opret Bruger",
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
            value = forNavn,
            label = { Text(text = "Fornavn", color = dustyRose) },
            onValueChange = { forNavn = it })
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = efterNavn,
            label = { Text(text = "Efternavn", color = dustyRose) },
            onValueChange = { efterNavn = it })
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = email,
            label = { Text(text = "E-mail", color = dustyRose) },
            onValueChange = { email = it })
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = kodeord,
            label = { Text(text = "Kodeord", color = dustyRose) },
            onValueChange = { kodeord = it },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )

                }
            }, visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        )

        Spacer(modifier = Modifier.height(50.dp))
        //MAKING A STANDARD BUTTON FOR TRYING THE LOGIN
        Button(onClick = {
            viewModel.putCredentialsAndCreateUser(
                forNavn = forNavn.text,
                efterNavn = efterNavn.text,
                email = email.text,
                kodeord = kodeord.text
            )
            //Navigation
            navController.navigate(Destination.OnMainAppStartScreen.route)
        }, colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)) {
            Text("Opret")
        }

    }
}
