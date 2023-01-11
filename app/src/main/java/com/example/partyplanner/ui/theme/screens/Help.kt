package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

        Column {
            val openDialog = remember { mutableStateOf(false) }

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { openDialog.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = CircleShape
            ) { Text("Button 1", color = Color.White) }
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
            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { openDialog.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = CircleShape
            ) { Text("Button 2", color = Color.White) }
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
            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { openDialog.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = CircleShape
            ) { Text("Button 3", color = Color.White) }
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
            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { openDialog.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = CircleShape
            ) { Text("Button 4", color = Color.White) }
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
            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { openDialog.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = CircleShape
            ) { Text("Button 5", color = Color.White) }
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
            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { openDialog.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = CircleShape
            ) { Text("Button 6", color = Color.White) }
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
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HelpScreenPreview() {
    HelpScreen()
}
