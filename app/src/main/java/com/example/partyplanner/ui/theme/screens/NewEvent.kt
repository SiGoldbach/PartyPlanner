package com.example.partyplanner.ui.theme.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp
import java.util.*

//Calendar implemented with inspiration and tutorial from https://www.geeksforgeeks.org/date-picker-in-android-using-jetpack-compose/
@Composable
fun CreateNewEvent(navController: NavHostController, viewModelOnApp: ViewModelOnApp) {
    //There is no need for a state collector here only to create the event in the firebase.

    var eventName by remember { mutableStateOf(TextFieldValue("")) }
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
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(standardDP))

        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventName,
            label = { Text(text = "Event navn", color = dustyRose) },
            onValueChange = { eventName = it },
            modifier = Modifier.width(width = 350.dp)
        )

        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventDescription,
            label = { Text(text = "Tilføj beskrivelse", color = dustyRose) },
            onValueChange = { eventDescription = it },
            modifier = Modifier.width(width = 350.dp)
        )


        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventLocation,
            label = { Text(text = "Tilføj Lokation", color = dustyRose) },
            onValueChange = { eventLocation = it },
            modifier = Modifier.width(width = 350.dp)
        )

        Spacer(modifier = Modifier.height(standardDP))


        Button(
            onClick = { mDatePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(backgroundColor = beige),
            border = BorderStroke(1.dp, color = Color.Gray),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .width(width = 350.dp)
                .height(56.dp)
        ) {
            Text(
                text = "Valgte dato: ${date.value}",
                modifier = Modifier
                    .fillMaxWidth(),
                //  fontStyle = FontStyle.Normal,
                fontSize = 16.sp, color = dustyRose,
                textAlign = TextAlign.Left


            )
        }

        // Spacer(modifier = Modifier.height(standardDP))

        Spacer(modifier = Modifier.height(100.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        )
        {
            Button(
                onClick = {
                    onclickForButton(
                        navController,
                        viewModelOnApp,
                        eventName.text,
                        date.value,
                        eventDescription = eventDescription.text,
                        eventLocation = eventLocation.text
                    )
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .size(width = 220.dp, height = 50.dp)

            ) {
                StandardText(text = "Opret begivenhed")
            }
        }
        Spacer(modifier = Modifier.height(standardDP))
    }

}

//Function required since the click requires more than one method to be run.
fun onclickForButton(
    navController: NavHostController,
    viewModel: ViewModelOnApp,
    name: String,
    date: String,
    eventDescription: String,
    eventLocation: String
) {
    navController.navigate(Destination.Event.route){
        navController.popBackStack()
    }
    viewModel.createEvent(name, date, eventDescription, eventLocation)
}

