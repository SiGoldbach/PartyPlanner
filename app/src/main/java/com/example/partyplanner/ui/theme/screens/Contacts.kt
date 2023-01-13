package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun ContactCard(navController: NavHostController) {
    val openDialogOne = remember { mutableStateOf(false) }
    val openDialogTwo = remember { mutableStateOf(false) }
    val openDialogThree = remember { mutableStateOf(false) }
    val openDialogFour = remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = CircleShape
            ) { Text("Valdemar Nielsen", color = Color.White) }
            if (openDialogOne.value) {
                AlertDialog(
                    onDismissRequest = { openDialogOne.value = false },
                    title = { Text(text = "Oprettelse af begivenheder", color = Color.Black) },
                    text = { Text("", color = Color.Black) },
                    confirmButton = {
                        Button(onClick = {
                            openDialogOne.value = false
                        }) { Text("OK") }
                    },
                    dismissButton = {
                        Button(onClick = {
                            openDialogOne.value = false
                        }) { Text("Cancel") }
                    })
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = CircleShape
            ) { Text("Sebastian Goldbach", color = Color.White) }
            if (openDialogTwo.value) {
                AlertDialog(
                    onDismissRequest = { openDialogTwo.value = false },
                    title = { Text(text = "Oprettelse af begivenheder", color = Color.Black) },
                    text = { Text("Here is a text", color = Color.Black) },
                    confirmButton = {
                        Button(onClick = {
                            openDialogTwo.value = false
                        }) { Text("OK") }
                    },
                    dismissButton = {
                        Button(onClick = {
                            openDialogTwo.value = false
                        }) { Text("Cancel") }
                    })
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = CircleShape
            ) { Text("Christian Hyltoft", color = Color.White) }
            if (openDialogThree.value) {
                AlertDialog(
                    onDismissRequest = { openDialogThree.value = false },
                    title = { Text(text = "Oprettelse af begivenheder", color = Color.Black) },
                    text = { Text("Here is a text", color = Color.Black) },
                    confirmButton = {
                        Button(onClick = {
                            openDialogThree.value = false
                        }) { Text("OK") }
                    },
                    dismissButton = {
                        Button(onClick = {
                            openDialogThree.value = false
                        }) { Text("Cancel") }
                    })
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(
                onClick = { openDialogFour.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = CircleShape
            ) { Text("Ismail Ali", color = Color.White) }
            if (openDialogFour.value) {
                AlertDialog(
                    onDismissRequest = { openDialogFour.value = false },
                    title = { Text(text = "Oprettelse af begivenheder", color = Color.Black) },
                    text = { Text("Here is a text", color = Color.Black) },
                    confirmButton = {
                        Button(onClick = {
                            openDialogFour.value = false
                        }) { Text("OK") }
                    },
                    dismissButton = {
                        Button(onClick = {
                            openDialogFour.value = false
                        }) { Text("Cancel") }
                    })
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}