package com.example.partyplanner.model

data class OnAppModel(
    var uid: String = "TEST2",
    var event: Event = Event(),
    var currentEvent: String = "",
    var events: List<Event> = listOf()
)