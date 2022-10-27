package com.example.partyplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
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
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    contentDescription = "Home",
                                    icon = Icons.Filled.Home
                                ),
                                MenuItem(
                                    id = "event",
                                    title = "Begivenhed",
                                    contentDescription = "Home",
                                    icon = Icons.Filled.Face
                                ),
                                MenuItem(
                                    id = "account",
                                    title = "Account",
                                    contentDescription = "Account",
                                    icon = Icons.Filled.Person
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