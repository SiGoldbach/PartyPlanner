package com.example.partyplanner.model

data class User(
    val email: String = "",
    val name: String = "",
    val surname: String = "",
    val uid: String = "TEST2",
    val description: String = "Write a description about yourself here",
    val eventIdentifiers: List<String> = listOf()
)


data class UserHelper(
    val EMAIl: String = "email",
    val NAME: String = "name",
    val SURNAME: String = "surname",
    val UID: String = "uid",
    val DESCRIPTION: String = "description",
    val EVENT_IDS: String = "eventIdentifiers"

    )




