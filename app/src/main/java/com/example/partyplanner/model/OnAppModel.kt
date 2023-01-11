package com.example.partyplanner.model

data class OnAppModel(
    var uid: String = "TEST2",
    var currentEventID: String = "",
    var events: List<Event> = listOf(),
    var wishLists: List<WishList> = listOf(),
    var currentGiftList: List<Gift> = listOf(),
    var eventsDataState: EventsDataState = EventsDataState.Loading,
    var currentEvent: Event = Event(),
    var topBarString: String = "",
    var user: User = User(),
    var currentWishListId: String = "",
    var currentGiftID: String = "",
    var currentGift: Gift = Gift()
)