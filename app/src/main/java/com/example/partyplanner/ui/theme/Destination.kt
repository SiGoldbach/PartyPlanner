package com.example.partyplanner.ui.theme

sealed class Destination (val route: String) {
    object Event : Destination("event")
    object NewEvent : Destination("newevent")
    object TestScreen : Destination("testscreen")
    object MakeUserScreen: Destination("opretBrugerscreen")
    object LoginScreen: Destination("loginScreen")
    object ComingEvents: Destination("mineEventsScreen")
    object WishList: Destination("WishlistScreen")
    object Welcome: Destination("WelcomeScreen")

}
