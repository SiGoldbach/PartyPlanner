package com.example.partyplanner.model

data class Event(
    val name: String = "",
    val date: String = "",
    val description: String = "",
    val participants: Int = 0,
    val totalInvites: Int = 0,
    val id: String = "",
    val location: String = "",
    //These are all the corresponding values you can add so only use these instead of you own string.

)

data class EventHelper(
    val id: String = "id",
    val NAME: String = "name",
    val DATE: String = "date",
    val DESCRIPTION: String = "description",
    val PARTICIPANTS: String = "participants",
    val TOTAL_INVITES: String = "totalInvites",
    val LOCATION: String = "location"

)

