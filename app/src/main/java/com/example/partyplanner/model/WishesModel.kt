package com.example.partyplanner.model

data class WishesModel(
    var testCounter: Int = 0,
    var popupControl: Boolean = false,
    var currentGift: Gift = Gift()
)