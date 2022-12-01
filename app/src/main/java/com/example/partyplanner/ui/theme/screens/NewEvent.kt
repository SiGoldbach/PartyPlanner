package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun CreateNewEvent(navController: NavHostController) {
    var eventName by remember { mutableStateOf(TextFieldValue("")) }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventName,
            label = { Text(text = "Event navn", color = dustyRose) },
            onValueChange = { eventName = it }


        )
        Spacer(modifier = Modifier.height(standardDP))
        StandardButton(
            output = "Start event",
            lambda = { navController.navigate(Destination.Event.route) })


    }

}