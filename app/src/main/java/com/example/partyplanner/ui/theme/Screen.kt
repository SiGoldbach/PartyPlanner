package com.example.partyplanner.ui.theme

sealed class Destination (val route: String) {
    object Event : Destination("event")
    object NewEvent : Destination("newevent")
    object TestScreen : Destination("testscreen")

}

