package com.example.partyplanner.naviagion

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.partyplanner.ui.theme.screens.ExperimentalScreen
import com.example.partyplanner.ui.theme.screens.LoginScreen
import com.example.partyplanner.ui.theme.screens.OpretBruger
import com.example.partyplanner.ui.theme.screens.WelcomeScreen
import com.example.partyplanner.viewModel.ViewModelOnApp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun NavigationAppHost(navController: NavHostController) {
    val viewModel = ViewModelOnApp()
    val ctx = LocalContext.current
    var dependableStartDestination: String = Destination.Welcome.route
    //If user is already logged in he goes to coming events screen.
    if (Firebase.auth.currentUser != null) {
        dependableStartDestination = Destination.LoginScreen.route
    }


    NavHost(navController = navController, startDestination = dependableStartDestination) {
        //Here there is no dependency injection yet so a standard event just get put in.

        composable(Destination.LoginScreen.route) { LoginScreen(navController = navController) }
        composable(Destination.MakeUserScreen.route) {
            OpretBruger(
                navController = navController,
            )
        }

        composable(Destination.Welcome.route) { WelcomeScreen(navController = navController) }
        composable(Destination.ComingEvents.route) {
            ExperimentalScreen(
                externalNav = navController,
                internalNav = rememberNavController(),
                viewModelOnApp = viewModel
            )
        }
        /*composable(Destination.Detail.route) { backStackEntry ->
            val elementId = backStackEntry.arguments?.getString("elementId")
            if(elementId == null){
                Toast.makeText(ctx, "No elementId found", Toast.LENGTH_SHORT).show()
            } else  {
                DetailScreen(elementId = elementId.toInt())
            }*/

    }
}