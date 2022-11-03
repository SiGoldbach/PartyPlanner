package com.example.partyplanner.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.partyplanner.*
import kotlinx.coroutines.launch

@Composable
fun TopOfScreenReusable(navController: NavController, content: @Composable () -> Unit) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        backgroundColor = beige,
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(stringResource = stringResource(id = R.string.Kommende_Begivenheder),
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
                        "begivenhed" -> navController.navigate(Screen.NewEventScreen.route)
                        "account" -> navController.navigate("account")
                        "menu" -> navController.navigate(Screen.EventScreen.route)
                    }

                    println("Clicked on ${it.title}")
                }
            )

        },
    ) {
        content()
        //Down here you can add your own screen to this bas Christian Hyltoft has made,
        //Later this will come as dependency injection as a composable function.
    }
}

/**
 * Here one can use this way of making the screen with the appbar
 * So this is now high cohesion so the appbar on top can be used againg and again.
 */


@Composable
fun NewEvent(navController: NavController) {
    Column {
        TopOfScreenReusable(
            navController = navController
        ) { NewEvent(navController = navController) }

    }

}

/**
 * This Events composable should be called with a list of event,
 * Or a function which acquires this list
 */
@Composable
fun Events(navController: NavController) {
    Column {
        TopOfScreenReusable(
            navController = navController
        ) { ComingEvents(navController = navController) }
    }

}


