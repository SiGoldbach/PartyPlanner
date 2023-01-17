package com.example.partyplanner.ui.theme.screens.eventScreens

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import coil.compose.rememberAsyncImagePainter
import com.example.partyplanner.R
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.StdText
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp


@Composable
fun MyEventScreen(navController: NavController, viewModelOnApp: ViewModelOnApp) {
    val appState by viewModelOnApp.uiState.collectAsState()
    val uri = Uri.parse("res/drawable-tvdpi/weddinghands.png")
    var selectImages by remember { mutableStateOf<Uri?>(uri) }

    viewModelOnApp.getSingleEvent(appState.currentEventID)

    Column (modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())
    ){

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
                        painter = rememberAsyncImagePainter(model = selectImages),
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {
                // Her skal Event name komme fra "event".
                // Gør text større, tykkere og mere overskrift-agtigt.
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
                StdText(string = appState.currentEvent.location)

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
                    Text(
                        text = "Ønsker",
                        fontSize = 18.sp, color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold


                    )

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
                    Text(
                        text = "Gæster",
                        fontSize = 18.sp, color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold


                    )
                }

            }
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { navController.navigate(Destination.InvitationScreen.route) },
                    colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier
                        .size(width = 180.dp, height = 80.dp),

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.invitationsimageremovebg),
                        contentDescription = null
                    )
                    Spacer(
                        modifier = Modifier
                            .width(7.dp)
                    )
                    Text(
                        text = "Inviter",
                        fontSize = 18.sp, color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
                    Button(
                        onClick = { navController.navigate(Destination.MyEventEditScreen.route) },
                        colors = ButtonDefaults.buttonColors(backgroundColor = beige),
                        shape = CircleShape,
                        modifier = Modifier.size(width = 69.dp, height = 60.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pencildrawing),
                            contentDescription = null,
                            modifier = Modifier.size(width = 35.dp, height = 35.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

            }
            // new row can be added here

        }
    }
}
