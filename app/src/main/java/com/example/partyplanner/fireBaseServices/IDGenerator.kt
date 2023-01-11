package com.example.partyplanner.fireBaseServices

//Written by
// https://stackoverflow.com/questions/46943860/idiomatic-way-to-generate-a-random-alphanumeric-string-in-kotlin
fun generateId(): String {
    return java.util.UUID.randomUUID().toString()

}