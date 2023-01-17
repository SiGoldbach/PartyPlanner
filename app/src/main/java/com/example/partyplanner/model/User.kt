package com.example.partyplanner.model

data class User(
    val email: String = "",
    var name: String = "",
    var surname: String = "",
    val uid: String = "TEST2",
    var description: String = "Write a description about yourself here",
    var eventIdentifiers: List<String> = listOf(),
    var wishListIdentifiers: MutableList<String> = mutableListOf(),
    val phoneNumber: String = ""
)


data class UserHelper(
    val EMAIl: String = "email",
    val NAME: String = "name",
    val SURNAME: String = "surname",
    val UID: String = "uid",
    val DESCRIPTION: String = "description",
    val EVENT_IDS: String = "eventIdentifiers",
    val WISHlIST_IDENTIFIERS: String = "wishListIdentifiers",
    val PHONE_NUMBER: String = "phoneNumber"


)




