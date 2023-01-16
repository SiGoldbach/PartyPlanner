package com.example.partyplanner.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.partyplanner.viewModel.ViewModelInvitations


@Composable
fun InvitationScreenLogic(ViewModelInvitations: ViewModelInvitations) {
    val appState by ViewModelInvitations.state.collectAsState()

    Text(
        text = "Inviterede",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
    )
    //SEND INVITATION BUTTON
    Button(
        onClick = {
            ViewModelInvitations.sendInvite(String = "")
        },
        //Align center
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = "Send invitation")
    }

    if (appState.listinvitation.isEmpty())
        Text(
            text = "Klik nederst på '+' for at tilføje en mailadresse",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxHeight()
        )
    else {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {

            items(appState.listinvitation) { index ->
                Log.e("_InviteList", "Mail Tilføjet" + index)

                Card(
                    backgroundColor = Color.Gray,
                    shape = RoundedCornerShape(20.dp),
                    elevation = 1.dp,
                    modifier = Modifier.padding(5.dp)
                ) {

                    Row(
                        modifier = Modifier.padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = index.id,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(10.dp)
                        )
                        Spacer(modifier = Modifier.fillMaxSize(0.7f))
                        Icon(

                            imageVector = Icons.Filled.Delete, contentDescription = "Delete",

                            modifier = Modifier.clickable {
                                ViewModelInvitations.removeInviteItem(
                                    inviteItem = index,
                                )
                            },
                            tint = Color.Red
                        )
                    }
                }
            }
        }

    }

}