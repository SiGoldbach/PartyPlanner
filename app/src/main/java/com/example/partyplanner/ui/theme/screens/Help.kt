package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
            .padding(5.dp)
            .verticalScroll(rememberScrollState()),
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
        Spacer(modifier = Modifier.padding(10.dp)
        )

        HelpButtons(output = "Oprettelse af begivenheder") {
            openDialogAndChangeText(
                viewModelHelp = viewModelHelp,
                title = "Oprettelse af begivenheder",
                descriptionText = "1. Klik på (Opret begivenhed) fra menuen. \n2. Giv begivenheden et navn, beskrivelse, lokation samt en dato. \n3. Klik på (Opret begivenhed). \n\nSå er du godt igang med din nye begivenhed.",
                buttonText = "OK"
            )
        }
        HelpButtons(output = "Ønskeliste") {
            openDialogAndChangeText(
                viewModelHelp = viewModelHelp,
                title = "Oprettelse af Ønskeliste",
                descriptionText = "1. Klik på (Ønskeliste) fra menuen. \n2. Klik på + knappen. \n3. Giv ønskelisten et navn. \n4. Tryk på (Opret ønskeliste).",
                buttonText = "OK"
            )
        }
        HelpButtons(output = "Invitationer") {
            openDialogAndChangeText(
                viewModelHelp = viewModelHelp,
                title = "Invitationer",
                descriptionText = "Indsæt tekst",
                buttonText = "OK"
            )
        }
        HelpButtons(output = "Deltagerliste") {
            openDialogAndChangeText(
                viewModelHelp = viewModelHelp,
                title = "Deltagerliste",
                descriptionText = "Indsæt tekst",
                buttonText = "OK"
            )
        }
        HelpButtons(output = "Vilkår og Betingelser") {
            openDialogAndChangeText(
                viewModelHelp = viewModelHelp,
                title = "Vilkår og Betingelser",
                descriptionText = "1. Introduktion: Disse vilkår og betingelser (\"Betingelserne\") regulerer din brug af PartyPlanner (\"Appen\") og ethvert indhold eller tjenester, der leveres gennem App'en. Ved at bruge appen accepterer du at være bundet af disse vilkår. Hvis du ikke accepterer disse vilkår, bør du ikke bruge appen. \n\n2. Aldersbegrænsninger: Du skal være mindst 18 år for at bruge appen. Ved at bruge appen repræsenterer og garanterer du, at du er 18 år eller ældre. \n\n3. Brugeradfærd: Du accepterer kun at bruge appen til lovlige formål og i overensstemmelse med disse vilkår. Du accepterer ikke at bruge appen til at uploade, poste, transmittere eller på anden måde gøre indhold tilgængeligt, der er ulovligt, skadeligt, truende, misbrugende, chikanerende, indviklet, ærekrænkende, vulgært, uanstændigt, inkrænkende, krænkende i en andens privatliv, hadefuldt eller racemæssigt, etnisk eller på anden måde anstødeligt. \n\n4. Immaterielle rettigheder: App'en og alt indhold og alle tjenester, der leveres gennem appen, inklusive men ikke begrænset til tekst, grafik, logoer, billeder og software, tilhører PartyPlanner og/eller dets licensgivere og er beskyttet af ophavsret, varemærke og andre love om intellektuel ejendomsret. Du accepterer ikke at bruge noget indhold eller tjenester leveret gennem appen til kommercielle formål uden udtrykkeligt skriftligt samtykke fra PartyPlanner. \n\n5. Ansvarsfraskrivelser: Appen og alt indhold og alle tjenester, der leveres gennem appen, leveres på \"som den er\" og \"som tilgængelig\". PartyPlanner giver ingen erklæringer eller garantier af nogen art, udtrykkelige eller underforståede, med hensyn til driften af appen eller oplysningerne, indholdet, materialerne eller produkterne inkluderet i appen. PartyPlanner garanterer ikke, at appen, dens servere eller nogen e-mail sendt fra PartyPlanner er fri for virus eller andre skadelige komponenter. \n\n6. Ansvarsbegrænsning: PartyPlanner kan under ingen omstændigheder holdes ansvarlig for nogen form for skader, der måtte opstå som følge af brugen af appen, inklusive men ikke begrænset til direkte, indirekte, tilfældige, straf- og følgeskader. \n7. Ændringer af vilkår: PartyPlanner forbeholder sig retten til at ændre disse vilkår til enhver tid, og du er bundet af sådanne ændringer. Du bør jævnligt tjekke disse vilkår for ændringer. \n\n8. Gældende lov: Disse vilkår skal være underlagt og fortolkes i overensstemmelse med lovgivningen i Danmark uden at give virkning til nogen principper om lovkonflikter. \n9. Kontakt os: Hvis du har spørgsmål eller bekymringer vedrørende disse vilkår, bedes du kontakte os på partyplanner@partyplanner.dk" +
                        "\n\nVed at bruge appen accepterer du at være bundet af disse vilkår. Hvis du ikke accepterer disse vilkår, bør du ikke bruge appen.",
                buttonText = "OK"
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HelpButtons(output = "Om") {
                openDialogAndChangeText(
                    viewModelHelp = viewModelHelp,
                    title = "Om",
                    descriptionText = "Alle har en begivenhed de gerne vil arrangere. Nu har du et sted at oprette dem med få klik. \n\nMed PartyPlanner har du appen med dig over alt, hvor du opgså kan dele dine begivenheder med dine venner og familie. \nHer kan du have styr på alt hvad der skal med til dine kommende begivenheder.",
                    buttonText = "OK"
                )
            }
        }
    }
}

@Composable
fun HelpButtons(output: String, lambda: () -> Unit) {
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
