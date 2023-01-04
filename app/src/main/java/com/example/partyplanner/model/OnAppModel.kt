package com.example.partyplanner.model

data class OnAppModel(
    var uid: String = "TEST2",
    var currentEvent: String = "",
    var events: List<Event> = listOf()
)