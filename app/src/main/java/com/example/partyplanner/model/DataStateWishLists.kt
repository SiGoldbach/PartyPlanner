package com.example.partyplanner.model

sealed class DataStateWishLists(){
    object Success : DataStateWishLists()
    object Failure : DataStateWishLists()
    object Loading : DataStateWishLists()
    object Empty : DataStateWishLists()
}
