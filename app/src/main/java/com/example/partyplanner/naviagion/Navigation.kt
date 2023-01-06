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

@Composable
fun NavigationAppHost(navController: NavHostController) {
    val viewModel = ViewModelOnApp()
    val ctx = LocalContext.current

    NavHost(navController = navController, startDestination = Destination.Welcome.route) {
        //Here there is no dependency injection yet so a standard event just get put in.

        composable(Destination.LoginScreen.route) { LoginScreen(navController = navController) }
        composable(Destination.MakeUserScreen.route) {
            OpretBruger(
                navController = navController,
                viewModelOnApp = viewModel
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