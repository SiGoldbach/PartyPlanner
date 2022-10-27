import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.partyplanner.ui.theme.StandardButton
import com.example.partyplanner.ui.theme.TopScreen
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun MainScreen() {

    Column(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
    ) {
        TopScreen()
        Box(
            contentAlignment = Alignment.Center,

            ) {
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(9.dp)) {
                Text(text = "Velkommen",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center) )// .padding(start = 140.dp)

                Box(
                    modifier = Modifier
                        .fillMaxWidth(1.0F)
                        .height(5.dp)
                        .background(dustyRose)
                        .clip(shape = RectangleShape)

                )
            }


        }
        Column {
            StandardButton(output = "50'th birthday party")
            StandardButton(output = "Uncles Marty's wedding")
            StandardButton(output = "Button 3")
        }


    }


}


