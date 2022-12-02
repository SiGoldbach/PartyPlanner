package com.example.partyplanner.naviagion

sealed class Destination (val route: String) {
    object Event : Destination("event")
    object NewEvent : Destination("newEvent")
    object TestScreen : Destination("testScreen")
    object MakeUserScreen: Destination("createUserScreen")
    object LoginScreen: Destination("loginScreen")
    object ComingEvents: Destination("mineEventsScreen")
    object WishList: Destination("WishlistScreen")
    object Welcome: Destination("WelcomeScreen")
    object Profile: Destination("Profile")

}
