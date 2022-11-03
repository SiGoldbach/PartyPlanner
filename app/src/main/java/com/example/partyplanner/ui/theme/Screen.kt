package com.example.partyplanner.ui.theme

sealed class Screen (val route: String) {
    object MainScreen : Screen("Events")
    object EventScreen : Screen("event_screen")
    object NewEventScreen :Screen("NewEvent")

}

