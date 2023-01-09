package com.example.partyplanner.naviagion

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.partyplanner.R
import com.example.partyplanner.ui.theme.TestScreen
import com.example.partyplanner.ui.theme.screens.*
import com.example.partyplanner.viewModel.ViewModelOnApp

/**
 * This is the internal naviagtion of the app this should work with now having two navcontrollers
 * One for being in the central app and one. that decides wether you are on onboarding or not.
 */

@Composable
fun InnerNav(
    onMainAppNavHostController: NavHostController,
    externalNavHostController: NavHostController,
    viewModel: ViewModelOnApp
) {
    //Here i am making a viewmodel since this nav function will only be called once every time,
    //a new user logs into the app
    NavHost(
        navController = onMainAppNavHostController,
        startDestination = Destination.ComingEvents.route
    ) {
        //Here there is no dependency injection yet so a standard event just get put in.
        composable(Destination.ComingEvents.route) {
            viewModel.updateTopBarString(stringResource(id = R.string.ComingEvents))
            ComingEvents(
                navController = onMainAppNavHostController,
                viewModelOnApp = viewModel
            )
        }
        composable(Destination.Event.route) {
            viewModel.updateTopBarString(stringResource(id = R.string.Dit_Event))
            MyEventScreen(
                navController = onMainAppNavHostController,
                viewModelOnApp = viewModel
            )
        }
        composable(Destination.NewEvent.route) {
            viewModel.updateTopBarString(stringResource(id = R.string.Ny_Begivenhed))
            CreateNewEvent(
                navController = onMainAppNavHostController,
                viewModel
            )
        }
        composable(Destination.MyEventEditScreen.route) {
            viewModel.updateTopBarString(stringResource(id = R.string.Edit_Event))

            UpdateEvent(
                navController = onMainAppNavHostController,
                viewModelOnApp = viewModel
            )
        }
        composable(Destination.TestScreen.route) { TestScreen(navController = onMainAppNavHostController) }
        composable(Destination.Profile.route) {
            viewModel.updateTopBarString(stringResource(id = R.string.Profile_page))

            Profile(
                internalNavController = onMainAppNavHostController,
                externalNavController = externalNavHostController
            )
        }
        composable(Destination.WishList.route) {
            viewModel.updateTopBarString(stringResource(id = R.string.Dine_wisList))

            Wishlist(navController = onMainAppNavHostController)
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