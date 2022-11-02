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
import com.example.partyplanner.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * When testing change the method called under the **ComposeTheme
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
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
                //Change here

                TempMain(navController = navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PartyPlannerTheme {
        val navController = rememberNavController()
        ComingEvents(navController = navController)
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