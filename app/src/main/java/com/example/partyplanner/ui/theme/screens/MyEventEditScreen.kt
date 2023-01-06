package com.example.partyplanner.ui.theme.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.partyplanner.R
import com.example.partyplanner.model.Event
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp
import java.util.*

@Composable
fun UpdateEvent(navController: NavController, event: Event, viewModelOnApp: ViewModelOnApp) {
    var eventName by remember { mutableStateOf(TextFieldValue("")) }
    var eventDate by remember { mutableStateOf(TextFieldValue("")) }
    var eventDescription by remember { mutableStateOf(TextFieldValue("")) }
    var eventLocation by remember { mutableStateOf(TextFieldValue("")) }
    val year: Int
    val month: Int
    val day: Int

    val context = LocalContext.current

    val date = remember { mutableStateOf("") }
    val calender = Calendar.getInstance()

    year = calender.get(Calendar.YEAR)
    month = calender.get(Calendar.MONTH)
    day = calender.get(Calendar.DAY_OF_MONTH)


    calender.time = Date()
    val mDatePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            date.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, year, month, day
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(10.dp),
            backgroundColor = beige
        ) {
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
        if (eventName.toString() == "") {
            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
                value = eventName,
                label = { Text(text = "event navn", color = dustyRose) },
                onValueChange = { eventName = it },
                modifier = Modifier.width(350.dp)
            )
        } else {
            OutlinedTextField(
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
                value = eventName,
                label = { Text(text = event.name, color = dustyRose) },
                onValueChange = { eventName = it },
                modifier = Modifier.width(350.dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { mDatePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(backgroundColor = beige),
            border = BorderStroke(1.dp, color = Color.DarkGray),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .size(width = 350.dp, height = 58.dp)
        ) {
            StandardText(text = event.date)
        }
        /*  OutlinedTextField(
          colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
          value = eventDate,
          label = { Text(text = event.date, color = dustyRose) },
          onValueChange = { eventDate = it },
      ) */
        Spacer(modifier = Modifier.height(standardDP))
        // make so that if the user has not chosen a description,
        // default value will be "Beskrivelse"
        //    if () { }
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventDescription,
            label = { Text(text = event.description, color = dustyRose) },
            onValueChange = { eventDescription = it },
            modifier = Modifier.width(350.dp)

        )
        Spacer(modifier = Modifier.height(standardDP))
        // make so that if the user has not chosen a location
        // default value will be "Lokation"
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventLocation,
            label = { Text(text = event.location, color = dustyRose) },
            onValueChange = { eventLocation = it },
            modifier = Modifier.width(350.dp)

        )
        Spacer(modifier = Modifier.height(50.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = {
                    //    viewModelOnApp.updateEventValues(event)
                    navController.navigate(Destination.Event.route)
                },
            ) {
                Text(text = "Gem Ændringer")
            }
            Spacer(modifier = Modifier.width(standardDP))
            Button(
                onClick = { navController.navigate(Destination.Event.route) },
            ) {
                Text(text = "X")
            }
        }
    }
}