import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.example.partyplanner.ui.theme.StandardButton
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.ui.theme.standardDP


// this shit dosent work
@Composable
fun OpretBruger(navController: NavController) {
    var PersonalInformation by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = PersonalInformation,
            label = { Text(text = "Fornavn", color = dustyRose) },
            onValueChange = { PersonalInformation = it }
        )
        Spacer(modifier = Modifier.height(standardDP))
        OutlinedTextField(colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
        value = PersonalInformation,
        label = { Text(text= "Efternavn", color = dustyRose)},
        onValueChange = {PersonalInformation = it }
        )

        Spacer(modifier = Modifier.height(standardDP))
        StandardButton(output = "Opret")

    }
}
