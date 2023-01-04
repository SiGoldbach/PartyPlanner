package com.example.partyplanner.ui.theme.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp
import java.util.*

//Calendar implemented with inspiration and tutorial from https://www.geeksforgeeks.org/date-picker-in-android-using-jetpack-compose/
@Composable
fun CreateNewEvent(navController: NavHostController, viewModelOnApp: ViewModelOnApp) {
    //There is no need for a state collector here only to create the event in the firebase.

    var eventName by remember { mutableStateOf(TextFieldValue("")) }
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



    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventName,
            label = { Text(text = "Event navn", color = dustyRose) },
            onValueChange = { eventName = it }


        )
        Spacer(modifier = Modifier.height(standardDP))
        Text(text = "Selected Date: ${date.value}")
        Spacer(modifier = Modifier.height(standardDP))


        Button(
            onClick = { mDatePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)
        ) {
            StandardText(text = "Pick date")
        }



        Button(
            onClick = { onclickForButton(navController, viewModelOnApp, eventName.text,date.value) },
            colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .size(width = 350.dp, height = 50.dp)

        ) {
            StandardText(text = "Opret begivenhed")
        }
        Spacer(modifier = Modifier.height(standardDP))

    }

}

//Function required since the click requires more than one method to be run.
fun onclickForButton(
    navController: NavHostController,
    viewModel: ViewModelOnApp,
    name: String,
    date: String
) {
    navController.navigate(Destination.Event.route)
    viewModel.createEvent(name, date, "Fun times ")
}

