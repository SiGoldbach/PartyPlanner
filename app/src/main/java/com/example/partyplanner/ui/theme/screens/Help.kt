package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
            AlertDialog(onDismissRequest = { viewModelHelp.setPopupFalse() },
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

        HelpButtons(output = "Oprettelse af begivenheder", lambda = {
            openDialogAndChangeText(
                viewModelHelp = viewModelHelp,
                title = "Oprettelse af begivenheder",
                descriptionText = "1. Klik på (Opret begivenhed) fra menuen. \n2. Giv begivenheden et navn, beskrivelse, lokation samt en dato. \n3. Klik på (Opret begivenhed). \n\nSå er du godt igang med din nye begivenhed.",
                buttonText = "OK"
            )
        })
        HelpButtons(output = "Ønskeliste", lambda = {
            openDialogAndChangeText(
                viewModelHelp = viewModelHelp,
                title = "Oprettelse af Ønskeliste",
                descriptionText = "1. Klik på (Ønskeliste) fra menuen. \n2. Klik på + knappen. \n3. Giv ønskelisten et navn. \n4. Tryk på (Opret ønskeliste).",
                buttonText = "OK"
            )
        })
        HelpButtons(output = "Invitationer", lambda = {
            openDialogAndChangeText(
                viewModelHelp = viewModelHelp,
                title = "Invitationer",
                descriptionText = "Indsæt tekst",
                buttonText = "OK"
            )
        })
        HelpButtons(output = "Deltagerliste", lambda = {
            openDialogAndChangeText(
                viewModelHelp = viewModelHelp,
                title = "Deltagerliste",
                descriptionText = "Indsæt tekst",
                buttonText = "OK"
            )
        })
        HelpButtons(output = "Juridiske vilkår", lambda = {
            openDialogAndChangeText(
                viewModelHelp = viewModelHelp,
                title = "Juridiske vilkår",
                descriptionText = "Indsæt tekst",
                buttonText = "OK"
            )
        })
        Column(modifier = Modifier.fillMaxSize() .padding(10.dp), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
            HelpButtons(output = "Om", lambda = {
                openDialogAndChangeText(
                    viewModelHelp = viewModelHelp,
                    title = "Om",
                    descriptionText = "Alle har en begivenhed de gerne vil arrangere. Nu har du et sted at oprette dem med få klik. \n\nMed PartyPlanner har du appen med dig over alt, hvor du opgså kan dele dine begivenheder med dine venner og familie. \nHer kan du have styr på alt hvad der skal med til dine kommende begivenheder.",
                    buttonText = "OK"
                )
            })
        }
    }
}

@Composable
fun HelpButtons(output: String, modifier: Modifier = Modifier, lambda: () -> Unit) {
    Button(
        onClick = lambda,
        colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier.size(width = 350.dp, height = 50.dp)

    ) {
        StandardText(text = output)
    }
    Spacer(modifier = Modifier.height(standardDP))
}

fun openDialogAndChangeText(
    viewModelHelp: ViewModelHelp, buttonText: String, descriptionText: String, title: String
) {
    viewModelHelp.updateTextValues(
        buttonText = buttonText, descriptionText = descriptionText, title = title
    )
    viewModelHelp.setPopupTrue()
}
