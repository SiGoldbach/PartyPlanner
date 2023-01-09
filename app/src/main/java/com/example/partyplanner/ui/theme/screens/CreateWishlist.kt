package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun CreateWishlist(navController: NavHostController) {

    var wishListName by remember { mutableStateOf(TextFieldValue("")) }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = wishListName,
            label = { Text(text = "Ønskeliste navn", color = dustyRose) },
            onValueChange = { wishListName = it },
            modifier = Modifier.width(width = 350.dp)


        )
        Spacer(modifier = Modifier.size(10.dp))
        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .size(width = 220.dp, height = 50.dp)

        ) {
            StandardText(text = "Opret ønskeliste")
        }


    }

}