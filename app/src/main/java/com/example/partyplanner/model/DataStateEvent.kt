package com.example.partyplanner.model

sealed class DataStateEvent {
    object Success : DataStateEvent()
    object Failure : DataStateEvent()
    object Loading : DataStateEvent()
    object Empty : DataStateEvent()
}