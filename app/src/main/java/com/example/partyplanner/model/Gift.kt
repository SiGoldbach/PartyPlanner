package com.example.partyplanner.model

/**
 * This is the initial thought i have on
 */
data class WishList(
    val id: String = "",
    val name: String = "",
    val picture: String = "",
    val ownerUID: String = "ownerUID",
    var giftAddressees: List<String> = listOf()


)

data class Gift(
    val id: String = "ID",
    val name: String = "NAME",
    val description: String = "EMPTY",
    val link: String = "EMPTY",
    var picture: String = "gs://partyplanner-7fed9.appspot.com/giftPictures/sko.png",
    val price: String = "0 kr",
    val ownerUID: String = "ownerUID",
    var wishListIDs: List<String> = listOf(),
    var realWish: Boolean = true,

    )


data class WishListHelper(
    val ID: String = "id",
    val NAME: String = "name",
    val PICTURE: String = "picture",
    val OWNER_UID: String = "ownerUID",
    val GIFT_ADDRESSES: String = "giftAddressees"

)

data class GiftHelper(
    val ID: String = "id",
    val NAME: String = "name",
    val DESCRIPTION: String = "description",
    val LINK: String = "link",
    val PICTURE: String = "picture",
    val PRICE: String = "price",
    val OWNER_UID: String = "ownerUID",
    val WISHLIST_IDS: String = "wishListIDs",
    var REALWISH: String = "realWish"
)









