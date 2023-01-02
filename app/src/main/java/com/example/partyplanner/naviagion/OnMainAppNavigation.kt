package com.example.partyplanner.naviagion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.partyplanner.ui.theme.TestScreen
import com.example.partyplanner.ui.theme.screens.*

/**
 * This is the internal naviagtion of the app this should work with now having two navcontrollers
 * One for being in the central app and one. that decides wether you are on onboarding or not.
 */

@Composable
fun InnerNav(
    onMainAppNavHostController: NavHostController,
    externalNavHostController: NavHostController
) {
    NavHost(
        navController = onMainAppNavHostController,
        startDestination = Destination.ComingEvents.route
    ) {
        //Here there is no dependency injection yet so a standard event just get put in.
        composable(Destination.ComingEvents.route) { ComingEvents(onMainAppNavHostController) }
        composable(Destination.Event.route) {
            MyEventScreen(
                navController = onMainAppNavHostController,
                event = com.example.partyplanner.model.Event("Event", "tomorow", "tomorow")
            )
        }
        composable(Destination.NewEvent.route) { CreateNewEvent(navController = onMainAppNavHostController) }
        composable(Destination.TestScreen.route) { TestScreen(navController = onMainAppNavHostController) }
        composable(Destination.Profile.route) {
            Profile(
                internalNavController = onMainAppNavHostController,
                externalNavController = externalNavHostController
            )
        }
        composable(Destination.WishList.route) { Wishlist(navController = onMainAppNavHostController) }
        /*composable(Destination.Detail.route) { backStackEntry ->
            val elementId = backStackEntry.arguments?.getString("elementId")
            if(elementId == null){
                Toast.makeText(ctx, "No elementId found", Toast.LENGTH_SHORT).show()
            } else  {
                DetailScreen(elementId = elementId.toInt())
            }*/

    }


}