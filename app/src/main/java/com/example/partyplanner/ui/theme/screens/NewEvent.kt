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
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelCreateEvent

@Composable
fun CreateNewEvent(navController: NavHostController) {
    val viewModel = ViewModelCreateEvent()
    //There is no need for a state collector here only to create the event in the firebase.

    var eventName by remember { mutableStateOf(TextFieldValue("")) }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventName,
            label = { Text(text = "Event navn", color = dustyRose) },
            onValueChange = { eventName = it }


        )
        Spacer(modifier = Modifier.height(standardDP))
        Button(
            onClick = { onclickForButton(navController, viewModel, eventName.text) },
            colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)

        ) {
            StandardText(text = "Event navn")
        }
        Spacer(modifier = Modifier.height(standardDP))

    }

}

fun onclickForButton(
    navController: NavHostController,
    viewModel: ViewModelCreateEvent,
    name: String
) {
    navController.navigate(Destination.Event.route)
    viewModel.createEvent(name)
}

