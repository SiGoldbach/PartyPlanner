import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.partyplanner.ui.theme.StandardButton
import com.example.partyplanner.ui.theme.TopScreen
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
    ) {
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
                .fillMaxWidth()
                .padding(0.dp,200.dp)
                ){
            StandardButton(output = "Log ind")
            StandardButton(output = "Opret bruger")
        }
    }
}