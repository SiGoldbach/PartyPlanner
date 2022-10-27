package com.example.partyplanner.ui.theme

sealed class Screen (val route: String) {
    object MainScreen : Screen("main_screen")
    object EventScreen : Screen("event_screen")

}

