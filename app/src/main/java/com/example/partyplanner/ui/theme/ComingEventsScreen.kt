package com.example.partyplanner.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ComingEvents(navController: NavController) {
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


    val list = listOf<Event>(a, b, c, d, e, f, g, h,ea,fa,ga,ha)

    Column {
        Box(
            contentAlignment = Alignment.Center,

            ) {
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(9.dp)) {
                Text(
                    text = "Kommende begivenheder",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .background(dustyRose)
                        .clip(shape = RectangleShape)

                )
            }


        }
        LazyColumn(modifier = Modifier.fillMaxHeight().fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            items(list) { item ->
                StandardButton2(item)
            }
        }
        /*Button(onClick = {
            navController.navigate(Screen.EventScreen.route)
        }) {
            Text(text = "Event")
        }
*/


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
    Spacer(modifier = Modifier.height(10.dp))

}

@Composable
fun StandardButton2(event: Event) {
    Button(

        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .size(width = 350.dp, height = 50.dp)

    ) {
        StandardText(text = event.name)
    }
    Spacer(modifier = Modifier.height(10.dp))

}

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


