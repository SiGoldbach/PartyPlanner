package com.example.partyplanner.model

sealed class DataStateWishes{
    object Success : DataStateWishes()
    object Failure : DataStateWishes()
    object Loading : DataStateWishes()
    object Empty : DataStateWishes()
}
