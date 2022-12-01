package com.example.partyplanner

import NavigationAppHost
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.*
import com.example.partyplanner.ui.theme.screens.OpretBruger
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


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
            val navController = rememberNavController()
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
                NavigationAppHost(navController = navController)
                //Change here
                //TopOfScreenReusable(navController = navController)
                val a = com.example.partyplanner.model.Event(
                    "Thomas bryllup",
                    "22/08/22",
                    "Vi holder bryllup fordi vi bliver gift"
                )
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
            val navController = rememberNavController()
        }
    }
}

