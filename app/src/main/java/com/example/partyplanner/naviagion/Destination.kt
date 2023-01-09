package com.example.partyplanner.naviagion

/**
 * These are the destination of the app there are two categories of destinations:
 * OnMainAppNavigation and Onboarding Navigation
 */
sealed class Destination (val route: String) {
    // OnMainAppNavigation:
    object Event : Destination("event")
    object NewEvent : Destination("newEvent")
    object TestScreen : Destination("testScreen")
    object ComingEvents: Destination("mineEventsScreen")
    object WishList: Destination("WishlistScreen")
    object Profile: Destination("Profile")
    object MyEventEditScreen: Destination("MyEventEditScreen")
    object AddWishToList: Destination("AddWishScreen")
    object CreateWishlist: Destination("CreateWishlist")


    //Onboarding Navigation:
    object LoginScreen: Destination("loginScreen")
    object Welcome: Destination("WelcomeScreen")
    object MakeUserScreen: Destination("createUserScreen")



}
