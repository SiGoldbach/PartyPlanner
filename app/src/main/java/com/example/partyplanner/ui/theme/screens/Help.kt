package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun HelpScreen() {
    Column {
        val openDialog = remember { mutableStateOf(false) }
        //horizontalAlignment = Alignment.CenterHorizontally,
        //modifier = Modifier.width(200.dp),
        //verticalArrangement = Arrangement.Center,

        //Spacer(modifier = Modifier.height(5.dp))

        Button(onClick = {
            openDialog.value = true
        }) {
            Text("")
        }
        if (openDialog.value) {
            AlertDialog(onDismissRequest = {
                openDialog.value = false
            }, title = {
                Text(text = "Dialog Title")
            }, text = {
                Text("Here is a text")
            }, confirmButton = {
                Button(onClick = {
                    openDialog.value = false
                }) {
                    Text("This is the Confirm Button")
                }
            }, dismissButton = {
                Button(onClick = {
                    openDialog.value = false
                }) {
                    Text("This is the dismiss Button")
                }
            })
        }

        //colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose)

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
