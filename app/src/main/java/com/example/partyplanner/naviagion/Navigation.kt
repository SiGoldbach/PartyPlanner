package com.example.partyplanner.naviagion

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.partyplanner.ui.theme.screens.*

@Composable
fun NavigationAppHost(navController: NavHostController) {
    val ctx = LocalContext.current

    NavHost(navController = navController, startDestination = Destination.Welcome.route) {
        //Here there is no dependency injection yet so a standard event just get put in.
        composable(Destination.ComingEvents.route) { ComingEventsWithScaffold(navController = navController) }
        composable(Destination.Event.route) {
            ExperimentalScreenForDemoForEvent(navController = navController)
        }
        composable(Destination.NewEvent.route) { CreateNewEventWithScaffold(navController = navController) }
        composable(Destination.TestScreen.route) { ComingEventsWithScaffold(navController = navController) }
        composable(Destination.LoginScreen.route) { LoginScreen(navController = navController) }
        composable(Destination.MakeUserScreen.route) { OpretBruger(navController = navController) }
        composable(Destination.Profile.route) { ExperimentalScreenForDemoWishProfile(navController = navController) }
        composable(Destination.Welcome.route) { WelcomeScreen(navController = navController) }
        composable(Destination.WishList.route) { ExperimentalScreenForDemoWishList(navController = navController) }
        /*composable(Destination.Detail.route) { backStackEntry ->
            val elementId = backStackEntry.arguments?.getString("elementId")
            if(elementId == null){
                Toast.makeText(ctx, "No elementId found", Toast.LENGTH_SHORT).show()
            } else  {
                DetailScreen(elementId = elementId.toInt())
            }*/

    }
}