import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.partyplanner.ui.theme.*
import com.example.partyplanner.R


@Composable
fun LoginText(text: String) {
    Text(
        text = text,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        fontSize = 38.sp, color = Color.Black
    )

}


@Composable
fun LoginScreenImage() {
    val image = painterResource(id = R.drawable.champagnecelebration)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
        )
    }
}
@Preview
@Composable
fun LoginScreen() {
    LoginScreenImage()
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Box(
            contentAlignment = Alignment.Center,

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .padding(9.dp)
                    .fillMaxWidth()
            ) {
                Box() {
                    LoginText(text = "Velkommen")
                }

                Spacer(modifier = Modifier.height(com.example.partyplanner.ui.theme.standardDP))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(Color.Black)
                        .clip(shape = RectangleShape)

                )
            }
        }

        Spacer(modifier = Modifier.height(425.dp))
        StandardButton(output = "Login")
        StandardButton(output = "Opret Bruger")
    }

}

