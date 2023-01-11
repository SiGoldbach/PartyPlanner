package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun HelpScreen() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        val openDialogOne = remember { mutableStateOf(false) }
        val openDialogTwo = remember { mutableStateOf(false) }
        val openDialogThree = remember { mutableStateOf(false) }
        val openDialogFour = remember { mutableStateOf(false) }
        val openDialogFive = remember { mutableStateOf(false) }
        val openDialogSix = remember { mutableStateOf(false) }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = CircleShape
        ) { Text("Oprettelse af begivenheder", color = Color.White) }
        if (openDialogOne.value) {
            AlertDialog(
                onDismissRequest = { openDialogOne.value = false },
                title = { Text(text = "Oprettelse af begivenheder", color = Color.Black) },
                text = { Text("Here is a text", color = Color.Black) },
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
            onClick = { openDialogTwo.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = CircleShape
        ) { Text("Invitationer", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Invitationer") },
                text = { Text("Here is a text") },
                confirmButton = {
                    Button(onClick = {
                    openDialogTwo.value = false
                }) { Text("OK") }
            },
                dismissButton = {
                    Button(onClick = { openDialogTwo.value = false })
                    { Text("Cancel") }
            })
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { openDialogThree.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = CircleShape
        ) { Text("Deltagerliste", color = Color.White) }
        if (openDialogThree.value) {
            AlertDialog(onDismissRequest = {
                openDialogThree.value = false
            }, title = {
                Text(text = "Dialog Title")
            }, text = {
                Text("Here is a text")
            }, confirmButton = {
                Button(onClick = {
                    openDialogThree.value = false
                }) {
                    Text("OK")
                }
            }, dismissButton = {
                Button(onClick = {
                    openDialogThree.value = false
                }) {
                    Text("Cancel")
                }
            })
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { openDialogFour.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = CircleShape
        ) { Text("Ønskeliste", color = Color.White) }
        if (openDialogFour.value) {
            AlertDialog(onDismissRequest = {
                openDialogFour.value = false
            }, title = {
                Text(text = "Dialog Title")
            }, text = {
                Text("Here is a text")
            }, confirmButton = {
                Button(onClick = {
                    openDialogFour.value = false
                }) {
                    Text("OK")
                }
            }, dismissButton = {
                Button(onClick = {
                    openDialogFour.value = false
                }) {
                    Text("Cancel")
                }
            })
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { openDialogFive.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = CircleShape
        ) { Text("Jurdiske Vilkår", color = Color.White) }
        if (openDialogFive.value) {
            AlertDialog(onDismissRequest = {
                openDialogFive.value = false
            }, title = {
                Text(text = "Dialog Title")
            }, text = {
                Text("Here is a text")
            }, confirmButton = {
                Button(onClick = {
                    openDialogFive.value = false
                }) {
                    Text("OK")
                }
            }, dismissButton = {
                Button(onClick = {
                    openDialogFive.value = false
                }) {
                    Text("Cancel")
                }
            })
        }
        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { openDialogSix.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = CircleShape
        ) { Text("Fik du ikke hjælp til dit problem?", color = Color.White) }
        if (openDialogSix.value) {
            AlertDialog(onDismissRequest = {
                openDialogSix.value = false
            }, title = {
                Text(text = "Fik du ikke hjælp til dit problem?")
            }, text = {
                Text("Here is a text")
            }, confirmButton = {
                Button(onClick = {
                    openDialogSix.value = false
                }) {
                    Text("OK")
                }
            }, dismissButton = {
                Button(onClick = {
                    openDialogSix.value = false
                }) {
                    Text("Cancel")
                }
            })
        }

        //Button(openDialog = openDialogOne)
        //DialogTwo(openDialog = dialogTwoOpen)
    }
}


@Composable
@Preview(showBackground = true)
fun HelpScreenPreview() {
    HelpScreen()
}

//DialogOne(openDialog = dialogOneOpen)
//DialogTwo(openDialog = dialogTwoOpen)