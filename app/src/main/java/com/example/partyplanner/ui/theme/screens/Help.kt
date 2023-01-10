package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun HelpScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Hjælp",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )

        Divider(color = Color.Black, thickness = 0.5.dp)

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { /* TODO */ },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose)
        ) {
            Text("Button 1")
        }

        Button(
            onClick = { /* Do something! */ },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose)
        ) {
            Text("Button 2")
        }

        Button(
            onClick = { /* Do something! */ },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose)
        ) {
            Text("Button 3")
        }

        Button(
            onClick = { /* Do something! */ },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose)
        ) {
            Text("Button 4")
        }

        Button(
            onClick = { /* Do something! */ },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose)
        ) {
            Text("Button 5")
        }

        Button(
            onClick = { /* Do something! */ },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose)
        ) {
            Text("Button 6")
        }
    }
}

//@Composable
//fun HelpComposer() {
//Card(
//modifier = Modifier.padding(start = 5.dp),
//onClick = { navControler.navigate(Destination.Help.route) },
//backroundColor = dustyRose
//)
//Column(
//modifier = Modifier
//.padding(start = 3.dp)
//.fillMaxWidth(),
//)
//}

@Composable
@Preview(showBackground = true)
fun HelpScreenPreview() {
    HelpScreen()
}
