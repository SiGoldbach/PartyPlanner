package com.example.partyplanner.fireBaseServices

fun generateId(): String {
    return java.util.UUID.randomUUID().toString()

}