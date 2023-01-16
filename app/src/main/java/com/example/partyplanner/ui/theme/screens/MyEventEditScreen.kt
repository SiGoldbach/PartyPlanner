package com.example.partyplanner.ui.theme.screens

import android.app.DatePickerDialog
import android.net.Uri
import android.widget.DatePicker
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.partyplanner.R
import com.example.partyplanner.model.Event
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp
import java.util.*

@Composable
fun UpdateEvent(navController: NavHostController, viewModelOnApp: ViewModelOnApp) {
    val appState by viewModelOnApp.uiState.collectAsState()
    var eventName by remember { mutableStateOf(TextFieldValue(appState.currentEvent.name)) }
    var eventDescription by remember { mutableStateOf(TextFieldValue(appState.currentEvent.description)) }
    var eventLocation by remember { mutableStateOf(TextFieldValue(appState.currentEvent.location)) }
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
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventName,
            label = { Text(text = "Event name", color = dustyRose) },
            onValueChange = { eventName = it },
            modifier = Modifier.width(350.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { mDatePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(backgroundColor = beige),
            border = BorderStroke(1.dp, color = Color.Gray),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .size(width = 350.dp, height = 58.dp)
        ) {
            Text(
                text = "Valgte dato: ${date.value}",
                modifier = Modifier
                    .fillMaxWidth(),
                fontStyle = FontStyle.Normal,
                fontSize = 16.sp, color = Color.Black,
                textAlign = TextAlign.Left
            )
        }

        Spacer(modifier = Modifier.height(standardDP))
        // make so that if the user has not chosen a description,
        // default value will be "Beskrivelse"
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventDescription,
            label = { Text(text = "Event description", color = dustyRose) },
            onValueChange = { eventDescription = it },
            modifier = Modifier.width(350.dp)

        )
        Spacer(modifier = Modifier.height(standardDP))
        // make so that if the user has not chosen a location
        // default value will be "Lokation"
        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = eventLocation,
            label = { Text(text = "Event location", color = dustyRose) },
            onValueChange = { eventLocation = it },
            modifier = Modifier.width(350.dp)

        )


        Spacer(modifier = Modifier.height(50.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = {
                    val newEvent = Event(
                        eventName.text,
                        date.value,
                        eventDescription.text,
                        appState.currentEvent.participants,
                        appState.currentEvent.totalInvites,
                        appState.currentEvent.id,
                        eventLocation.text,
                        appState.currentEvent.specificParticipants,
                        appState.currentEvent.ownerUID
                    )
                    viewModelOnApp.updateEventValues(newEvent)
                    navController.navigate(Destination.Event.route)
                }

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

/**
 * This updates the whole event and should be fine for this project,
 * Maybe in the future some changes are so common values might be changed one at a time.
 */

/*
//  https://www.youtube.com/watch?v=kZKL_JvPDG0&ab_channel=KiloLoco
// Guide how to pick a picture from users phone
private var pictureUriState = mutableStateOf<Uri?>(null)
private val pictureChooserLauncher = ActivityResultContracts.GetContent()

@Composable
fun PictureChoose() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                androidx.compose.material.Text("Vælg billede fra galleri")
            }
        }
    }
}
*/