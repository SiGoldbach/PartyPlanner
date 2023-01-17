package com.example.partyplanner.naviagion

import AddWishToList
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.partyplanner.R
import com.example.partyplanner.ui.theme.TestScreen
import com.example.partyplanner.ui.theme.screens.*
import com.example.partyplanner.viewModel.ViewModelHelp
import com.example.partyplanner.viewModel.ViewModelInvitations
import com.example.partyplanner.viewModel.ViewModelOnApp
import com.example.partyplanner.viewModel.ViewModelWishes

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
    val viewModelHelp = ViewModelHelp()
    val viewModelWishes = ViewModelWishes()
    val viewModelInvitations = ViewModelInvitations()
    //Here i am making a viewmodel since this nav function will only be called once every time,
    //a new user logs into the app
    NavHost(
        navController = onMainAppNavHostController,
        startDestination = Destination.ComingEvents.route
    ) {
        //Here there is no dependency injection yet so a standard event just get put in.
        composable(Destination.ComingEvents.route) {
            viewModel.setEventStateLoading()
            viewModel.updateTopBarString(stringResource(id = R.string.Coming_Events))
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
        composable(Destination.ProfileEditScreen.route) {
            viewModel.updateTopBarString("Rediger profil")
            ProfileEditScreen(
                internalNavController = onMainAppNavHostController,
                viewModelOnApp = viewModel
            )
        }
        composable(Destination.AddWishlistToEvent.route) {
            viewModel.updateTopBarString("Dine Ønskelister")
            Wishlist2(
                navController = onMainAppNavHostController,
                viewModel
            )
        }

        composable(Destination.Wishes.route) {
            viewModel.setWishesStateLoading()
            viewModel.updateTopBarString("Din nuværende ønskeliste")
            Wishes(
                navController = onMainAppNavHostController,
                viewModelOnApp = viewModel,
                viewModelWishes = viewModelWishes
            )
        }

        composable(Destination.AddWishToList.route) {
            AddWishToList(
                navController = onMainAppNavHostController
            )
        }
        composable(Destination.CreateWishlist.route) {

        }
        composable(Destination.MyEventEditScreen.route) {
            viewModel.updateTopBarString(stringResource(id = R.string.Edit_Event))

            UpdateEvent(
                navController = onMainAppNavHostController,
                viewModelOnApp = viewModel
            )
        }
        composable(Destination.Help.route) {
            viewModel.updateTopBarString(stringResource(id = R.string.Help_Screen))

            HelpScreen(viewModelHelp)
        }
        composable(Destination.Profile.route) {
            viewModel.updateTopBarString(stringResource(id = R.string.Profile_Page))

            Profile(
                internalNavController = onMainAppNavHostController,
                externalNavController = externalNavHostController, viewModelOnApp = viewModel
            )
        }
        composable(Destination.WishList.route) {
            viewModel.setEventWishListsStateLoading()
            viewModel.updateTopBarString(stringResource(id = R.string.Dine_wisList))

            Wishlist(navController = onMainAppNavHostController, viewModel)
        }
        composable(Destination.CreateWishlist.route) {
            viewModel.updateTopBarString(stringResource(id = R.string.Opret_ønskeliste))
            CreateWishlist(navController = onMainAppNavHostController, viewModel)
        }
        composable(Destination.Contacts.route) {
            ContactCard(navController = onMainAppNavHostController)
        }
        composable(Destination.CreateWish.route) {
            CreateNewWIsh(
                viewModelOnApp = viewModel,
                navHostController = onMainAppNavHostController
            )
        }
        composable(Destination.InvitationScreen.route) {
            InvitationScreen(
                viewModelInvitations = viewModelInvitations,
                navHostController = onMainAppNavHostController,
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