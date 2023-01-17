package com.example.partyplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.partyplanner.naviagion.NavigationAppHost
import com.example.partyplanner.ui.theme.PartyPlannerTheme
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.google.accompanist.systemuicontroller.rememberSystemUiController


/**
 * When testing change the method called under the **ComposeTheme
 * Link to video used for google authentication.
 * https://www.youtube.com/watch?v=dPeS92y4gRs&ab_channel=DeveloperChunk
 */


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        //firebase auth instance

        //Configure google sign in


        setContent {
            val rootNavController = rememberNavController()
            rememberNavController()

            PartyPlannerTheme {

                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = dustyRose,
                        darkIcons = false
                    )
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = beige
                ) {

                }
                //After these side effects the app will either begin on coming events or login screen
                //OpretBruger(navController = navController)
                //Change here
                //TopOfScreenReusable(navController = navController)
                NavigationAppHost(navController = rootNavController)
                //OpretBruger(navController = navController)
                //Wishlist(navController = navController)
                //MyEventScreen(a, navController = navController)
            }
        }

    }


    //I have made some changes here to test the navigation

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PartyPlannerTheme {
            rememberNavController()
        }
    }
}

