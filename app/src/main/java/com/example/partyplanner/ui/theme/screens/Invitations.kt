package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.example.partyplanner.model.Invitations
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelInvitations
import com.example.partyplanner.viewModel.ViewModelOnApp

//Dataclass for ViewModel
@Composable
fun InvitationScreen(
    viewModelInvitations: ViewModelInvitations,
    navHostController: NavHostController,
    viewModelOnApp: ViewModelOnApp
) {
    val openDialog =
        remember { mutableStateOf(false) }// for remembering the value of dialog is open or not
    val viewModelInvitations by remember { mutableStateOf(ViewModelInvitations()) } // for remembering the value of dialog is open or not

    Scaffold(

        floatingActionButton = { //floating acion button
            FloatingActionButton(
                onClick = { // when floating action button click it change the value of opendialog to true,
                    openDialog.value = true
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Inviter andre",
                )

                if (openDialog.value) {
                    //check if openDialog value is true then it display Alert Dialog
                    FullScreenDialog(
                        openDialog = openDialog,
                        viewModelInvitations = viewModelInvitations,
                        viewModelOnApp = viewModelOnApp
                    )

                }
            }
        },


        ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            InvitationScreenLogic(
                ViewModelInvitations = viewModelInvitations,
                viewModelOnApp = viewModelOnApp
            )
        }
    }
}

@Composable
fun FullScreenDialog(
    openDialog: MutableState<Boolean>,
    viewModelInvitations: ViewModelInvitations,
    viewModelOnApp: ViewModelOnApp

) {

    var task by remember { mutableStateOf(TextFieldValue()) } // for remembering the value of task

    AlertDialog(
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false),

        shape = RoundedCornerShape(16.dp),
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back

            openDialog.value = false
        },
        title = {
            Text(
                text = "Add Mail", modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        },

        text = {
            Column(
                modifier = Modifier.padding(10.dp),
            ) {

                TextField(
                    value = task, onValueChange = { newText ->
                        task = newText
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.textFieldColors(

                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }
            Text(text = "Mailadresse:", modifier = Modifier.padding(20.dp))

        },
        confirmButton = {
            Button(

                onClick = {
                    openDialog.value = false
                    viewModelInvitations.addInviteToList(Invitations(task.text))
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
            ) {
                Text(
                    "Tilføj", color = Color.White,
                )
            }
        },
        dismissButton = {
            Button(

                onClick = {
                    openDialog.value =
                        false
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            ) {
                Text(
                    "Afbryd", color = Color.White,
                )
            }
        }
    )
}