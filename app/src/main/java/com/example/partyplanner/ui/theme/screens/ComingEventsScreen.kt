package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.partyplanner.R
import com.example.partyplanner.model.DataStateEvent
import com.example.partyplanner.model.Event
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.ui.theme.screens.reuseables.emptyLoadingScreen
import com.example.partyplanner.ui.theme.screens.reuseables.loadingScreen
import com.example.partyplanner.viewModel.ViewModelOnApp


val standardDP: Dp = 10.dp

@Composable
fun ComingEvents(navController: NavHostController, viewModelOnApp: ViewModelOnApp) {
    val appState by viewModelOnApp.uiState.collectAsState()
    viewModelOnApp.updateEventList()
    if (appState.dataStateEvent == DataStateEvent.Loading) {
        loadingScreen(text = "Indlæser kommende begivenheder")
    }
    if (appState.dataStateEvent == DataStateEvent.Empty) {
        emptyLoadingScreen(
            text = "Ingen begivenheder er lavet endnu, lav en ny begivenhed ", buttonText = "Opret ny begivenhed"
        ) {
            navController.navigate(Destination.NewEvent.route)
        }
    }
    if (appState.dataStateEvent == DataStateEvent.Success) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
        ) {
            //Text(text = "Du har " + appState.events.size + " events")
            LazyVerticalGrid(
                modifier = Modifier.fillMaxHeight(0.9F),
                columns = GridCells.Adaptive(minSize = 160.dp),
                // cells = GridCells.Adaptive(minSize = 160.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                items(appState.events) { item ->
                    EventComposer(item, navController, viewModelOnApp)
                }
            }
            FloatingActionButton(
                onClick = { navController.navigate(Destination.NewEvent.route) },
                backgroundColor = dustyRose,
                contentColor = Color.White,
                modifier = Modifier.size(width = 200.dp, height = 50.dp)
            ) {
                Text(text = "Opret event")

            }


        }
    }
    if (appState.dataStateEvent == DataStateEvent.Failure) {
        Text(text = "Kunne ikke hente dine event prøv at luk og åben appen igen")
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
        modifier = Modifier.size(width = 350.dp, height = 50.dp)

    ) {
        StandardText(text = output)
    }
    Spacer(modifier = Modifier.height(standardDP))

}

/**
 * Here is the standard eventComposer, now with just a default image of loading.
 * Since no picture has been loaded yet from the viewmodels apis.
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EventComposer(event: Event, navController: NavHostController, viewModelOnApp: ViewModelOnApp) {
    Card(border = BorderStroke(width = 2.dp, color = dustyRose),
        modifier = Modifier
            .size(width = 350.dp, height = 300.dp)
            .padding(10.dp),
        backgroundColor = beige,
        onClick = {
            clickOnEvent(
                navController = navController, viewModelOnApp = viewModelOnApp, event = event
            )
        }) {
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
                    painter = rememberAsyncImagePainter(model = "gs://partyplanner-7fed9.appspot.com/LnRrYf6e_400x400.jpg"),
                    contentDescription = stringResource(id = R.string.Coming_events),
                    modifier = Modifier.size(200.dp),
                    contentScale = ContentScale.Fit,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.padding(5.dp))
                Column {
                    Row {
                        Text(text = event.totalInvites.toString() + " Deltagere")
                    }
                    Row {
                        Text(text = event.participants.toString() + " Inviterede")
                    }
                }
                Spacer(modifier = Modifier.weight(1F))
            }


        }
    }

}

fun clickOnEvent(navController: NavHostController, event: Event, viewModelOnApp: ViewModelOnApp) {
    navController.navigate(Destination.Event.route)
    viewModelOnApp.setCurrentEventId(event.id)
}
//Til eventcomposer skal importeres 2 billeder 1 til personer der deltager og et til ikke-besvarede invitationer.
//Desuden skal al teksten inkapsuleres i en box mere...


@Composable
fun StandardText(text: String) {
    Text(
        text = text, fontStyle = FontStyle.Normal, fontSize = 16.sp, color = Color.White
    )

}
