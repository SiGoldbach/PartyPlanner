package com.example.partyplanner.ui.theme.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.partyplanner.R
import com.example.partyplanner.model.MenuItem
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.naviagion.InnerNav
import com.example.partyplanner.ui.theme.AppBar
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.viewModel.ViewModelOnApp
import kotlinx.coroutines.launch


@Composable
fun ExperimentalScreen(
    externalNav: NavHostController,
    internalNav: NavHostController,
    viewModelOnApp: ViewModelOnApp
) {
    val appState by viewModelOnApp.uiState.collectAsState()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        backgroundColor = beige,
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(stringResource = appState.topBarString,
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
                        id = "home",
                        title = "Begivenheder",
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
                        title = "Opret begivenhed",
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
                        "home" -> internalNav.navigate(Destination.ComingEvents.route)
                        "profile" -> internalNav.navigate(Destination.Profile.route)
                        "begivenhed" -> internalNav.navigate(Destination.NewEvent.route)
                        "ønskeliste" -> internalNav.navigate(Destination.WishList.route)
                        "hjælp" -> internalNav.navigate(Destination.TestScreen.route)
                    }
                    scope.launch { scaffoldState.drawerState.close() }

                    println("Clicked on ${it.title}")
                }
            )

        },
    ) {
        //Here the internal navigation is, this makes this scaffold and top bar be reused every time and,
        //Only this value will be changed.
        InnerNav(internalNav, externalNav, viewModelOnApp)
    }
}