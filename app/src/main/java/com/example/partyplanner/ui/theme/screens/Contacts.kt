package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.partyplanner.ui.theme.dustyRose

@Composable
fun ContactCard(navController: NavHostController) {
    Contacts()

}


@Composable
fun Contacts() {
    val openDialogOne = remember { mutableStateOf(false) }
    val openDialogTwo = remember { mutableStateOf(false) }
    val openDialogThree = remember { mutableStateOf(false) }
    val openDialogFour = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Valdemar Nielsen", color = Color.White) }
            if (openDialogOne.value) {
                AlertDialog(
                    onDismissRequest = { openDialogOne.value = false },
                    title = { Text(text = "Valdemar Nielsen", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:valdemar@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogOne.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Sebastian Goldbach", color = Color.White) }
            if (openDialogTwo.value) {
                AlertDialog(
                    onDismissRequest = { openDialogTwo.value = false },
                    title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogTwo.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogThree.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                //Size of the button
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Christian Hyltoft", color = Color.White) }
            if (openDialogThree.value) {
                AlertDialog(
                    onDismissRequest = { openDialogThree.value = false },
                    title = { Text(text = "Christian Hyltoft", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:chrishy@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogThree.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogFour.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Ismail Ali", color = Color.White) }
            if (openDialogFour.value) {
                AlertDialog(
                    onDismissRequest = { openDialogFour.value = false },
                    title = { Text(text = "Ismail Ali", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:ismail@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogFour.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Valdemar Nielsen", color = Color.White) }
            if (openDialogOne.value) {
                AlertDialog(
                    onDismissRequest = { openDialogOne.value = false },
                    title = { Text(text = "Valdemar Nielsen", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:valdemar@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogOne.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Sebastian Goldbach", color = Color.White) }
            if (openDialogTwo.value) {
                AlertDialog(
                    onDismissRequest = { openDialogTwo.value = false },
                    title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogTwo.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogThree.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                //Size of the button
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Christian Hyltoft", color = Color.White) }
            if (openDialogThree.value) {
                AlertDialog(
                    onDismissRequest = { openDialogThree.value = false },
                    title = { Text(text = "Christian Hyltoft", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:chrishy@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogThree.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogFour.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Ismail Ali", color = Color.White) }
            if (openDialogFour.value) {
                AlertDialog(
                    onDismissRequest = { openDialogFour.value = false },
                    title = { Text(text = "Ismail Ali", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:ismail@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogFour.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Valdemar Nielsen", color = Color.White) }
            if (openDialogOne.value) {
                AlertDialog(
                    onDismissRequest = { openDialogOne.value = false },
                    title = { Text(text = "Valdemar Nielsen", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:valdemar@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogOne.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Sebastian Goldbach", color = Color.White) }
            if (openDialogTwo.value) {
                AlertDialog(
                    onDismissRequest = { openDialogTwo.value = false },
                    title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogTwo.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogThree.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                //Size of the button
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Christian Hyltoft", color = Color.White) }
            if (openDialogThree.value) {
                AlertDialog(
                    onDismissRequest = { openDialogThree.value = false },
                    title = { Text(text = "Christian Hyltoft", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:chrishy@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogThree.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogFour.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Ismail Ali", color = Color.White) }
            if (openDialogFour.value) {
                AlertDialog(
                    onDismissRequest = { openDialogFour.value = false },
                    title = { Text(text = "Ismail Ali", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:ismail@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogFour.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Valdemar Nielsen", color = Color.White) }
            if (openDialogOne.value) {
                AlertDialog(
                    onDismissRequest = { openDialogOne.value = false },
                    title = { Text(text = "Valdemar Nielsen", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:valdemar@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogOne.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogOne.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Sebastian Goldbach", color = Color.White) }
            if (openDialogTwo.value) {
                AlertDialog(
                    onDismissRequest = { openDialogTwo.value = false },
                    title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogTwo.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogThree.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                //Size of the button
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Christian Hyltoft", color = Color.White) }
            if (openDialogThree.value) {
                AlertDialog(
                    onDismissRequest = { openDialogThree.value = false },
                    title = { Text(text = "Christian Hyltoft", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:chrishy@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogThree.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { openDialogFour.value = true },
                colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) { Text("Ismail Ali", color = Color.White) }
            if (openDialogFour.value) {
                AlertDialog(
                    onDismissRequest = { openDialogFour.value = false },
                    title = { Text(text = "Ismail Ali", color = Color.Black) },
                    text = {
                        Text(
                            "Adresse: Langevej 22 " + "Mail:ismail@gmail.com " + "Telefon:12345678",
                            color = Color.Black
                        )
                    },


                    confirmButton = {
                        Button(onClick = {
                            openDialogFour.value = false
                        }) { Text("LUK") }
                    },
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { openDialogOne.value = true },
            colors = ButtonDefaults.textButtonColors(backgroundColor = dustyRose),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) { Text("Sebastian Goldbach", color = Color.White) }
        if (openDialogTwo.value) {
            AlertDialog(
                onDismissRequest = { openDialogTwo.value = false },
                title = { Text(text = "Sebastian Goldbach", color = Color.Black) },
                text = {
                    Text(
                        "Adresse: Langevej 22 " + "Mail:sebgold@gmail.com " + "Telefon:12345678",
                        color = Color.Black
                    )
                },


                confirmButton = {
                    Button(onClick = {
                        openDialogTwo.value = false
                    }) { Text("LUK") }
                },
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }

}
