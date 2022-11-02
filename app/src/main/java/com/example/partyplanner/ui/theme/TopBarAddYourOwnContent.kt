package com.example.partyplanner.ui.theme

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.example.partyplanner.AppBar
import com.example.partyplanner.DrawerBody
import com.example.partyplanner.DrawerHeader
import com.example.partyplanner.MenuItem
import kotlinx.coroutines.launch

@Composable
fun TempMain(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        backgroundColor = beige,
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch { scaffoldState.drawerState.open() }
                }
            )
        },
        //Gør så man ikke kan "dragge" hvis menuen er lukket
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "menu",
                        title = "Menu",
                        contentDescription = "The menu",
                        icon = Icons.Filled.Menu
                    ),
                    MenuItem(
                        id = "profile",
                        title = "Profil",
                        contentDescription = "Go to profile",
                        icon = Icons.Filled.Face
                    ),
                    MenuItem(
                        id = "begivenhed",
                        title = "Begivenheder",
                        contentDescription = "Begivenheder",
                        icon = Icons.Filled.Add
                    ),
                    MenuItem(
                        id = "ønskeliste",
                        title = "Ønskeliste",
                        contentDescription = "Wishlist",
                        icon = Icons.Filled.Edit
                    ),
                    MenuItem(
                        id = "hjælp",
                        title = "Hjælp",
                        contentDescription = "support",
                        icon = Icons.Filled.Info
                    ),
                ),
                onItemClick = {
                    when (it.id) {
                        "home" -> navController.navigate("home")
                        "event" -> navController.navigate("event")
                        "account" -> navController.navigate("account")
                    }

                    println("Clicked on ${it.title}")
                }
            )

        },
    ) {
        ComingEvents(navController = navController)
    }
}


