package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ContactsPage(navController: NavController) {
    val dummyContacts = listOf(
        Contact("John Doe", "555-555-5555", "johndoe@example.com"),
        Contact("Jane Smith", "555-555-5556", "janesmith@example.com"),
        Contact("Bob Johnson", "555-555-5557", "bobjohnson@example.com")
    )

    Column(modifier = Modifier.padding(16.dp)) {
        for (contact in dummyContacts) {
            ContactCard(contact)
        }
    }
}

@Composable
private fun ContactCard(contact: Contact) {
    val isDialogOpen = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = contact.name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
            Text(
                text = contact.phone,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            )
            Text(
                text = contact.email,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            IconButton(onClick = { isDialogOpen.value = true }) {
                Icons.Default.Delete
            }
            if (isDialogOpen.value) {
                AlertDialog(
                    onDismissRequest = { isDialogOpen.value = false },
                    title = { Text("Slet kontakt") },
                    text = {
                        Text("Er du sikker på at du vil slette ${contact.name} ?")
                    },
                    buttons = {
                        Row {
                            Button(onClick = { isDialogOpen.value = false }) {
                                Text("Afbryd")
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = { isDialogOpen.value = false }) {
                                Text("Slet")
                            }
                        }
                    }
                )
            }
        }
    }
}

data class Contact(val name: String, val phone: String, val email: String){


}
