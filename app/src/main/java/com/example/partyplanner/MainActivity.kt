package com.example.partyplanner

import LoginScreen
import android.os.Bundle
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
                val navController = rememberNavController()
                NavigationAppHost(navController = navController)            }

        }
    }
}

@Composable
fun NavigationAppHost (navController: NavHostController) {
    val ctx = LocalContext.current

    NavHost(navController = navController, startDestination = "event" ){
        composable(Destination.Event.route) { Event(navController) }
        composable(Destination.NewEvent.route) { NewEvent(navController) }
        composable(Destination.TestScreen.route) { TestScreen(navController) }
        /*composable(Destination.Detail.route) { backStackEntry ->
            val elementId = backStackEntry.arguments?.getString("elementId")
            if(elementId == null){
                Toast.makeText(ctx, "No elementId found", Toast.LENGTH_SHORT).show()
            } else  {
                DetailScreen(elementId = elementId.toInt())
            }*/

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

