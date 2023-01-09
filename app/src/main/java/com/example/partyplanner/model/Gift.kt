package com.example.partyplanner.model

/**
 * This is the initial thought i have on
 */
data class GiftList(
    val id: String = "ID",
    val name: String = "",
    val description: String = "",
    val link: String = "",
    val picture: String = "",
    val price: Int = 0,
    val ownerUID: String = "ownerUID"

    )
data class Gift(
    val id: String = "ID",
    val name: String = "",
    val description: String = "",
    val link: String = "",
    val picture: String = "",
    val price: Int = 0,
    val ownerUID: String = "ownerUID",
    var realWish: Boolean = true

)


data class GiftHelper(
    val id: String = "id",
    val NAME: String = "name",
    val DESCRIPTION: String = "description",
    val LINK: String = "",
    val PICTURE: String = "",
    val PRICE: Int = 0,
    val OWNER_UID: String = "ownerUID"

)