package com.example.partyplanner.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.partyplanner.model.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class ViewModelOnApp : ViewModel() {


    private val userInfo =
        MutableStateFlow(
            OnAppModel(
            )
        )
    val uiState: StateFlow<OnAppModel> = userInfo.asStateFlow()


    init {
        val testUID = "TESTUIDFORNOW"
        val auth = Firebase.auth
        userInfo.update { t ->
            t.copy(
                uid = testUID
            )
        }
    }

    private val db = FirebaseFirestore.getInstance()

    fun updateTopBarString(string: String) {
        userInfo.update { t -> t.copy(topBarString = string) }

    }

    fun createEvent(
        eventName: String,
        date: String,
        description: String,
        location: String
    ): Boolean {
        val generatedID = (0..99999999999).random().toString()

        var boolean = false
        val addEvent = db.collection("events")
        val data1 = hashMapOf(
            EventHelper().id to generatedID,
            EventHelper().NAME to eventName,
            EventHelper().DATE to date,
            EventHelper().DESCRIPTION to description,
            EventHelper().PARTICIPANTS to 0,
            EventHelper().TOTAL_INVITES to 0,
            EventHelper().LOCATION to location,
            EventHelper().SPECIFIC_PARTICIPANTS to listOf<String>(),
            EventHelper().OWNER_UID to userInfo.value.uid


        )
        //This function is only used when creating an event so setting the current eventId to the
        //On just being made is fine.
        userInfo.update { t -> t.copy(currentEventID = generatedID) }

        addEvent.document(generatedID).set(data1)
            .addOnSuccessListener {
                boolean = true
                val user = db.collection("USERS").document(userInfo.value.uid)
                user.get().addOnSuccessListener { doc ->
                    val specificUser = doc.toObject(User::class.java)
                    val newList = specificUser!!.eventIdentifiers.toMutableList()
                    newList.add(generatedID)
                    specificUser.eventIdentifiers = newList
                    db.collection("USERS").document(userInfo.value.uid)
                        .update(UserHelper().EVENT_IDS, specificUser.eventIdentifiers)
                }


            }.addOnFailureListener { println("Failure") }
        return boolean
    }

    fun createWishList(name: String) {
        val generatedID = (0..99999999999).random().toString()
        val addWishList = db.collection("wishLists")


        val data1 = hashMapOf(
            WishListHelper().ID to generatedID,
            WishListHelper().NAME to name,
            WishListHelper().GIFT_ADDRESSES to listOf<String>(),
            WishListHelper().PICTURE to "EMPTY",
            WishListHelper().OWNER_UID to userInfo.value.uid
        )
        println("The event name is: " + name)
        println("The event id is: " + generatedID)
        println("The uid is: " + userInfo.value.uid)
        userInfo.update { t -> t.copy(currentWishListId = generatedID) }

        addWishList.document(generatedID).set(data1)
            .addOnSuccessListener {
                println("Getting here into the succesListener ")
                val user = db.collection("USERS").document(userInfo.value.uid)
                user.get().addOnSuccessListener { doc ->
                    val specificUser = doc.toObject(User::class.java)
                    val newList = specificUser!!.wishListIdentifiers.toMutableList()
                    println("The length of the currentWishList is: " + newList.size)
                    newList.add(generatedID)
                    println("The length of the currentWishList is: " + newList.size)
                    specificUser.wishListIdentifiers = newList
                    db.collection("USERS").document(userInfo.value.uid)
                        .update(UserHelper().WISHlIST_IDENTIFIERS, specificUser.wishListIdentifiers)


                }


            }.addOnFailureListener {
                println("Cant update wishlist")
            }


    }


    fun updateEventList() {
        getAllEvents()


    }


    private fun getAllEvents() {
        val user = db.collection("USERS").document(userInfo.value.uid)
        val eventsInDB = db.collection("events")
        val tempEventsList = mutableListOf<Event>()

        user.get().addOnSuccessListener { doc ->
            val userFromDB = doc.toObject(User::class.java)
            //Log.v("events", "Getting events")
            Log.v("i will try to fetch events", userFromDB!!.eventIdentifiers.size.toString())


            for (event in userFromDB.eventIdentifiers) {
                eventsInDB.document(event).get().addOnSuccessListener { docWithEvent ->
                    val gotEvent = docWithEvent.toObject(Event::class.java)
                    tempEventsList.add(gotEvent!!)
                    //println("List has size " + tempEventsList.size.toString())
                    //println(tempEventsList[0].ownerUID)
                    //This if only updates when all the elements have been added to the list
                    if (tempEventsList.size == userFromDB.eventIdentifiers.size) {
                        userInfo.update { t ->
                            t.copy(
                                events = tempEventsList,
                            )
                        }
                    }

                }.addOnFailureListener {
                    println("Could not find event")
                }


            }
            userInfo.update { t ->
                t.copy(
                    eventsDataState = EventsDataState.Success(tempEventsList)
                )
            }
        }.addOnFailureListener {
            Log.v("i will try to fetch events", "Could not get the events from the server")

        }


    }

    fun getAllWishLists() {
        val user = db.collection("USERS").document(userInfo.value.uid)
        val wishListsInDB = db.collection("wishLists")
        val tempWishList = mutableListOf<WishList>()

        user.get().addOnSuccessListener { doc ->
            val userFromDB = doc.toObject(User::class.java)
            //Log.v("events", "Getting events")
            Log.v(
                "i will try to fetch wishlists: ",
                userFromDB!!.wishListIdentifiers.size.toString()
            )
            for (wishListIdentifier in userFromDB.wishListIdentifiers) {
                wishListsInDB.document(wishListIdentifier).get()
                    .addOnSuccessListener { docWithEvent ->
                        println("I fecthed this document:" + docWithEvent.id)
                        val gotWishList = docWithEvent.toObject(WishList::class.java)
                        gotWishList!!.id
                        tempWishList.add(gotWishList)
                        println("List has size " + tempWishList.size.toString())
                        //This if only updates when all the elements have been added to the list
                        if (tempWishList.size == userFromDB.wishListIdentifiers.size) {
                            userInfo.update { t ->
                                t.copy(
                                    wishLists = tempWishList
                                )
                            }
                        }

                    }.addOnFailureListener {
                        println("Could not find wishlist")
                    }


            }


        }.addOnFailureListener {
            println("Could not find the user")
        }
    }

    fun getSingleEvent(eventId: String) {
        val eventsInDB = db.collection("events").document(eventId)
        eventsInDB.get().addOnSuccessListener { curEventDoc ->
            val eventFromDB = curEventDoc.toObject(Event::class.java)

            userInfo.update { t -> t.copy(currentEvent = eventFromDB!!) }
        }


    }

    fun setCurrentEvent(event: Event) {
        userInfo.update { t ->
            t.copy(
                currentEvent = event,
            )
        }

    }

    /**
     * This updates the whole event and should be fine for this project,
     * Maybe in the future some changes are so common values might be changed one at a time.
     */
    fun updateEventValues(event: Event) {
        val addEvent = db.collection("events")
            .document(event.id)
        val data1 = hashMapOf(
            EventHelper().id to event.id,
            EventHelper().NAME to event.name,
            EventHelper().DATE to event.date,
            EventHelper().DESCRIPTION to event.description,
            EventHelper().PARTICIPANTS to event.participants,
            EventHelper().TOTAL_INVITES to event.totalInvites,
            EventHelper().LOCATION to event.location,
            EventHelper().SPECIFIC_PARTICIPANTS to event.specificParticipants,
            EventHelper().OWNER_UID to event.ownerUID
        )
        addEvent.set(data1)
            .addOnSuccessListener { Log.d("Firestore", "Event updated successfully") }
            .addOnFailureListener { e -> Log.d("Firestore", "Fail in update", e) }

    }

    fun setCurrentEventId(id: String) {
        userInfo.update { t -> t.copy(currentEventID = id) }


    }

    fun getProfileInfoAndUpdate() {
        val user = db.collection("USERS").document(userInfo.value.uid)

        user.get().addOnSuccessListener { doc ->
            val userFromDB = doc.toObject(User::class.java)
            userInfo.update { t -> t.copy(user = userFromDB!!) }
        }


    }


}