package com.example.partyplanner.model

sealed class EventsDataState {
    class Success(val data: MutableList<Event>) : EventsDataState()
    class Failure(val message: String) : EventsDataState()
    object Loading : EventsDataState()
    object Empty : EventsDataState()
}