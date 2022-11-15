package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.partyplanner.R
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.Event

val standardDP: Dp = 10.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComingEvents(navController: NavHostController) {
    val a = Event("event1")
    val b = Event("event1")
    val c = Event("event1")
    val d = Event("event1")
    val e = Event("event1")
    val f = Event("event1")
    val g = Event("event1")
    val h = Event("event1")
    val ea = Event("event1")
    val fa = Event("event1")
    val ga = Event("event1")
    val ha = Event("event1")


    val list = listOf(a, b, c, d, e, f, g, h, ea, fa, ga, ha)

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxHeight(),
            cells = GridCells.Adaptive(minSize = 160.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(list) { item ->
                EventComposer(item, navController)
            }
        }


    }


}


/**
 * This is supposed to be the standard button used for navigating the app.
 */
@Composable
fun StandardButton(output: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
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
        modifier = Modifier.size(width = 350.dp, height = 300.dp).padding(10.dp), backgroundColor = beige
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = event.name)
            Text(text = "11-01-2044")
            Box (modifier = Modifier.fillMaxHeight(0.8F)){
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
                Column() {
                    Text(text = "35 Deltager")
                    Text(text = "15 Invitationer")
                }
                Spacer(modifier = Modifier.weight(1F))
                Button(
                    onClick = { /*TODO*/ },
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

/**
 * This method will later take a lot of information in to display the correct stuff now
 * It just a dummy to kinda make it look like the reel thing.
 */
@Composable
fun TopScreen(navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(75.dp)
                .clip(shape = CircleShape)
                .background(Color.Black)
        )
        Box(modifier = Modifier.padding(10.dp)) {
            StandardText(text = "MyMan")

        }

    }
}




