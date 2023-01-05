package com.example.partyplanner.model

data class OnAppModel(
    var uid: String = "TEST2",
    var currentEventID: String = "",
    var events: List<Event> = listOf()
)