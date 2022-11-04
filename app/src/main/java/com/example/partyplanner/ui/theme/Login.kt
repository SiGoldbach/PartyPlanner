import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.partyplanner.ui.theme.*

val standardDP: Dp = 10.dp
@Composable
fun LoginScreen() {
    val a = Event("Login")
    val b = Event("Opret Bruger")

    val list = listOf(a, b)

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Box(
            contentAlignment = Alignment.Center,

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .padding(9.dp)
                    .fillMaxWidth()
            ) {
                Button(

                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier
                        .size(width = 250.dp, height = 50.dp)

                ) {
                    StandardText(text = "PartyPlanner")
                }
                Spacer(modifier = Modifier.height(com.example.partyplanner.ui.theme.standardDP))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .background(dustyRose)
                        .clip(shape = RectangleShape)

                )
            }


        }
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(list) { item ->
                EventComposer(item)
            }
        }
        /* Column{
        Box(
            contentAlignment = Alignment.Center,

            ) {
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(9.dp)) {
                Text(
                    text = "Velkommen",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                )// .padding(start = 140.dp)

                Box(
                    modifier = Modifier
                        .fillMaxWidth(1.0F)
                        .height(5.dp)
                        .background(dustyRose)
                        .clip(shape = RectangleShape)
                )
            }

        }
        Column (verticalArrangement = Arrangement.Center,
            modifier = Modifier
                    // Changes location of buttons on screen
            //    .fillMaxWidth()
              //  .padding(0.dp,100.dp)
                ){
            StandardButton(output = "Log ind")
            StandardButton(output = "Opret bruger")
        }
    }  */
    }
}
