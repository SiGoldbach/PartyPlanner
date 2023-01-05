package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.R
import com.example.partyplanner.model.Event
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.model.Gift
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.viewModel.ViewModelOnApp

@Composable
fun UpdateEvent(navController: NavController,event: Event, viewModelOnApp: ViewModelOnApp) {
    var eventName by remember { mutableStateOf(TextFieldValue("")) }
    var eventDate by remember { mutableStateOf(TextFieldValue("")) }
    var eventDescription by remember { mutableStateOf(TextFieldValue("")) }
    var eventLocation by remember { mutableStateOf(TextFieldValue("")) }

    Column() {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(10.dp),
            backgroundColor = beige
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.fillMaxHeight(1F)) {
                    Image(
                        // billede her skal komme fra event.
                        painter = painterResource(id = R.drawable.weddinghands),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventName,
            label = { Text(text = event.name, color = dustyRose) },
            onValueChange = { eventName = it }
        )
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventDate,
            label = { Text(text = event.date, color = dustyRose) },
            onValueChange = { eventDate = it }
        )
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventDescription,
            label = { Text(text = event.description, color = dustyRose) },
            onValueChange = { eventDescription = it }
        )
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventLocation,
            label = { Text(text = event.location, color = dustyRose) },
            onValueChange = { eventLocation = it }
        )
        Spacer(modifier = Modifier.height(50.dp))
        
        Button(onClick = { viewModelOnApp.updateEventValues(event) }) {
            Text(text = "Gem Ændringer")
        }
    }
}
