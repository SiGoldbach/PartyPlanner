package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.partyplanner.R
import com.example.partyplanner.model.Event
import com.example.partyplanner.model.EventsDataState
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp


val standardDP: Dp = 10.dp

@Composable
fun ComingEvents(navController: NavHostController, viewModelOnApp: ViewModelOnApp) {
    val appState by viewModelOnApp.uiState.collectAsState()
    viewModelOnApp.updateEventList()
    if (appState.eventsDataState is EventsDataState.Loading) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.loading_pic),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight(0.5F)
                    .fillMaxWidth(0.5F),
            )

            Text(text = "Loading events", fontSize = 20.sp)
        }


    }
    if (appState.eventsDataState is EventsDataState.Success) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxHeight(),
                columns = GridCells.Adaptive(minSize = 160.dp),
                // cells = GridCells.Adaptive(minSize = 160.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                items(appState.events) { item ->
                    EventComposer(item, navController)
                }
            }


        }
    }
    if (appState.eventsDataState is EventsDataState.Failure) {
        Text(text = "Could not get the events ", fontSize = 20.sp)

    }
    if (appState.eventsDataState is EventsDataState.Empty) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(5.dp)
        ) {
            Text(text = "No events where found on the server.", fontSize = 20.sp)
            Text(
                text = "Create a new one by presseing the three stripes on the top left ",
                fontSize = 20.sp
            )

        }
    }


}


/**
 * This is supposed to be the standard button used for navigating the app.
 */
@Composable
fun StandardButton(output: String, modifier: Modifier = Modifier, lambda: () -> Unit) {
    Button(
        onClick = lambda,
        colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .size(width = 350.dp, height = 50.dp)

    ) {
        StandardText(text = output)
    }
    Spacer(modifier = Modifier.height(standardDP))

}

/**
 * Here is the standard eventComposer, now with just a default image of loading.
 * Since no picture has been loaded yet from the viewmodels apis.
 */
@Composable
fun EventComposer(event: Event, navController: NavHostController) {
    Card(
        border = BorderStroke(width = 2.dp, color = dustyRose),
        modifier = Modifier
            .size(width = 350.dp, height = 300.dp)
            .padding(10.dp), backgroundColor = beige
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = event.name)
            Text(text = event.date)
            Box(modifier = Modifier.fillMaxHeight(0.8F)) {
                Image(
                    painter = painterResource(id = R.drawable.loading_picture),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.padding(5.dp))
                Column {
                    Row {
                        Text(text = event.totalInvites.toString())
                    }
                    Row {
                        Text(text = event.participants.toString())
                    }
                }
                Spacer(modifier = Modifier.weight(1F))
                Button(
                    onClick = { navController.navigate(Destination.Event.route) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)
                ) {
                    Text(text = "Gå til")

                }

            }


        }
    }


}
//Til eventcomposer skal importeres 2 billeder 1 til personer der deltager og et til ikke-besvarede invitationer.
//Desuden skal al teksten inkapsuleres i en box mere...


@Composable
fun StandardText(text: String) {
    Text(
        text = text,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp, color = Color.White
    )

}






