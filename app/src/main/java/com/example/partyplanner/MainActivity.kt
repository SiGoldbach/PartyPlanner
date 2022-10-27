package com.example.partyplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.partyplanner.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationDrawerComposeTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
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
                                when(it.id){
                                    "home" -> navController.navigate("home")
                                    "event" -> navController.navigate("event")
                                    "account" -> navController.navigate("account")
                                }

                                println("Clicked on ${it.title}")
                            }
                        )

                    },
                ){

                }
            }
        }
    }
}


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PartyPlannerTheme {
        }
    }



//PartyPlannerTheme {
//    val systemUiController = rememberSystemUiController()
//    SideEffect {
//        systemUiController.setStatusBarColor(
//            color = dustyRose,
//            darkIcons = false
//        )
//    }
//    // A surface container using the 'background' color from the theme
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = beige
//    ) {
//    }
//}