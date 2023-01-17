package com.example.partyplanner.model

sealed class DataStateWishListOnEvent{
    object Success : DataStateWishListOnEvent()
    object Failure : DataStateWishListOnEvent()
    object Loading : DataStateWishListOnEvent()
    object Empty : DataStateWishListOnEvent()
}
