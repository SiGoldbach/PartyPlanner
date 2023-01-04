package com.example.partyplanner.model

data class OnAppModel(
    val uid: String,
    val event: Event,
    val currentEvent: String,
    val events: List<Event>
)