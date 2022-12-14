package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.R
import com.example.partyplanner.model.Event
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.StdText
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp


@Composable
fun MyEventScreen(navController: NavController, viewModelOnApp: ViewModelOnApp) {
    val appState by viewModelOnApp.uiState.collectAsState()
    viewModelOnApp.getSingleEvent(appState.currentEventID)

    Column {

        //Top picture with event name
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                // .size(width = 350.dp, height = 300.dp)
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
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            backgroundColor = beige,
            border = BorderStroke(width = 2.dp, color = dustyRose)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Her skal Event name komme fra "event".
                // G??r text st??rre, tykkere og mere overskrift-agtigt.
                Text(
                    text = appState.currentEvent.name,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp, color = Color.Black,
                    modifier = Modifier
                )
                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                // Date text here comes from "event".
                StdText(string = appState.currentEvent.date)

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
                // Description here comes from "event".
                StdText(string = appState.currentEvent.description)

            }
        }
        // insert 2 buttons for Attending and NOT attending. (amount + face picture)
        // insert wish-list button with default text.
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier
                        .size(width = 180.dp, height = 80.dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.wishlistpicture),
                        contentDescription = null
                    )
                    Spacer(
                        modifier = Modifier
                            .width(7.dp)
                    )
                    StdText(string = "??nsker")

                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier
                        .size(width = 180.dp, height = 80.dp),

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.attending_picture),
                        contentDescription = null
                    )
                    Spacer(
                        modifier = Modifier
                            .width(7.dp)
                    )
                    StdText(string = "G??ster")
                }

            }
            Box(contentAlignment = Alignment.BottomEnd) {
                Row(horizontalArrangement = Arrangement.End) {
                    Button(
                        onClick = { navController.navigate(Destination.MyEventEditScreen.route) },
                        colors = ButtonDefaults.buttonColors(backgroundColor = beige),
                        shape = CircleShape,
                        modifier = Modifier.size(width = 54.dp, height = 45.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pencildrawing),
                            contentDescription = null,
                            modifier = Modifier.size(width = 20.dp, height = 20.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
            // new row can be added here

        }
    }
    // Here we have the edit button
    /*
    Box(v) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .size(width = 60.dp, height = 60.dp),

            ) {
            Image(
                painter = painterResource(id = R.drawable.editpencilfour),
                contentDescription = null,
                modifier = Modifier
                    .height(800.dp)
                    .width(70.dp)
                    .clip(CircleShape),
            )
        }

    } */

}
