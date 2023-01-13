package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelHelp

@Composable
fun HelpScreen(viewModelHelp: ViewModelHelp) {
    val helpScreenState by viewModelHelp.helpInfoState.collectAsState()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (helpScreenState.dialogOpener) {
            AlertDialog(
                onDismissRequest = { viewModelHelp.setPopupFalse() },
                title = {
                    Text(
                        text = helpScreenState.title,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                },
                text = { Text(helpScreenState.descriptionText, color = Color.Black) },
                confirmButton = {
                    Button(
                        onClick = { viewModelHelp.setPopupFalse() },
                        colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose)
                    ) { Text(helpScreenState.buttonText, color = Color.White) }
                })
        }
        Spacer(modifier = Modifier.padding(10.dp))








        HelpButtons(
            output = "Test",
            lambda = {
                openDialogAndChangeText(
                    viewModelHelp = viewModelHelp,
                    title = "test",
                    descriptionText = "test",
                    buttonText = "test"
                )
            }
        )
        HelpButtons(
            output = "Test",
            lambda = {
                openDialogAndChangeText(
                    viewModelHelp = viewModelHelp,
                    title = "test",
                    descriptionText = "test",
                    buttonText = "test"
                )
            }
        )
        HelpButtons(
            output = "Test",
            lambda = {
                openDialogAndChangeText(
                    viewModelHelp = viewModelHelp,
                    title = "test",
                    descriptionText = "test",
                    buttonText = "test"
                )
            }
        )

    }
}

@Composable
fun HelpButtons(output: String, modifier: Modifier = Modifier, lambda: () -> Unit) {
    Button(
        onClick = lambda,
        colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .size(width = 350.dp, height = 50.dp)

    ) {
        StandardText(text = output)
    }
    Spacer(modifier = Modifier.height(standardDP))

}

fun openDialogAndChangeText(
    viewModelHelp: ViewModelHelp,
    buttonText: String,
    descriptionText: String,
    title: String
) {
    viewModelHelp.updateTextValues(
        buttonText = buttonText,
        descriptionText = descriptionText,
        title = title
    )
    viewModelHelp.setPopupTrue()

}


