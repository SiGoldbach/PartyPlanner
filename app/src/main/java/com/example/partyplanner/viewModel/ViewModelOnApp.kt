package com.example.partyplanner.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.partyplanner.fireBaseServices.*
import com.example.partyplanner.model.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking
import java.io.InputStream


class ViewModelOnApp : ViewModel() {


    private val userInfo =
        MutableStateFlow(
            OnAppModel(
                currentGift = Gift(realWish = true)

            )
        )
    val uiState: StateFlow<OnAppModel> = userInfo.asStateFlow()


    init {
        val testUID = "TESTUIDFORNOW"
        val auth = Firebase.auth.currentUser
        if (auth != null) {
            userInfo.update { t -> t.copy(uid = auth.uid) }

        } else {
            userInfo.update { t ->
                t.copy(
                    uid = testUID
                )
            }
        }

    }

    /**
     * This is used before an event some method since this viewmodel is made beffore the current user is signed in
     */
    private fun makeSureCorrectUIDIsUsed() {
        val testUID = "TESTUIDFORNOW"
        val auth = Firebase.auth.currentUser
        if (auth != null) {
            userInfo.update { t -> t.copy(uid = auth.uid) }

        } else {
            userInfo.update { t ->
                t.copy(
                    uid = testUID
                )
            }
        }


    }

    private val db = FirebaseFirestore.getInstance()
    private val cloudStorage = Firebase.storage

    fun updateTopBarString(string: String) {
        userInfo.update { t -> t.copy(topBarString = string) }

    }

    fun createEvent(
        eventName: String,
        date: String,
        description: String,
        location: String,
        pictureString: String
    ): Boolean {
        val generatedID = generateId()

        var boolean = false
        val addEvent = db.collection(EVENTS)
        val data1 = hashMapOf(
            EventHelper().id to generatedID,
            EventHelper().NAME to eventName,
            EventHelper().DATE to date,
            EventHelper().DESCRIPTION to description,
            EventHelper().PARTICIPANTS to 0,
            EventHelper().TOTAL_INVITES to 0,
            EventHelper().LOCATION to location,
            EventHelper().SPECIFIC_PARTICIPANTS to listOf<String>(),
            EventHelper().OWNER_UID to userInfo.value.uid,
            EventHelper().PICTURE to pictureString


        )
        //This function is only used when creating an event so setting the current eventId to the
        //On just being made is fine.
        userInfo.update { t -> t.copy(currentEventID = generatedID) }

        addEvent.document(generatedID).set(data1)
            .addOnSuccessListener {
                boolean = true
                val user = db.collection(USERS).document(userInfo.value.uid)
                user.get().addOnSuccessListener { doc ->
                    val specificUser = doc.toObject(User::class.java)
                    val newList = specificUser!!.eventIdentifiers.toMutableList()
                    newList.add(generatedID)
                    specificUser.eventIdentifiers = newList
                    db.collection(USERS).document(userInfo.value.uid)
                        .update(UserHelper().EVENT_IDS, specificUser.eventIdentifiers)
                }


            }.addOnFailureListener { println("Failure") }
        return boolean
    }

    fun createWishList(name: String) {
        val generatedID = generateId()
        val addWishList = db.collection(WISHLISTS)


        val data1 = hashMapOf(
            WishListHelper().ID to generatedID,
            WishListHelper().NAME to name,
            WishListHelper().GIFT_ADDRESSES to listOf<String>(),
            WishListHelper().PICTURE to "EMPTY",
            WishListHelper().OWNER_UID to userInfo.value.uid
        )
        println("The event name is: $name")
        println("The event id is: $generatedID")
        println("The uid is: " + userInfo.value.uid)
        userInfo.update { t -> t.copy(currentWishListId = generatedID) }

        addWishList.document(generatedID).set(data1)
            .addOnSuccessListener {
                println("Getting here into the succesListener ")
                val user = db.collection(USERS).document(userInfo.value.uid)
                user.get().addOnSuccessListener { doc ->
                    val specificUser = doc.toObject(User::class.java)
                    val newList = specificUser!!.wishListIdentifiers.toMutableList()
                    println("The length of the currentWishList is: " + newList.size)
                    newList.add(generatedID)
                    println("The length of the currentWishList is: " + newList.size)
                    specificUser.wishListIdentifiers = newList
                    db.collection(USERS).document(userInfo.value.uid)
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
        makeSureCorrectUIDIsUsed()
        val user = db.collection(USERS).document(userInfo.value.uid)
        val eventsInDB = db.collection(EVENTS)
        val tempEventsList = mutableListOf<Event>()

        user.get().addOnSuccessListener { doc ->
            val userFromDB = doc.toObject(User::class.java)
            //Log.v("events", "Getting events")
            Log.v("i will try to fetch events", userFromDB!!.eventIdentifiers.size.toString())

            if (userFromDB.eventIdentifiers.isEmpty()) {
                userInfo.update { t ->
                    t.copy(
                        dataStateEvent = DataStateEvent.Empty
                    )
                }
            } else {
                for (event in userFromDB.eventIdentifiers) {
                    eventsInDB.document(event).get().addOnSuccessListener { docWithEvent ->
                        val gotEvent = docWithEvent.toObject(Event::class.java)
                        tempEventsList.add(gotEvent!!)
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
                        dataStateEvent = DataStateEvent.Success
                    )
                }
            }

        }.addOnFailureListener {
            Log.v("i will try to fetch events", "Could not get the events from the server")

        }


    }

    fun getAllWishLists() {
        makeSureCorrectUIDIsUsed()
        val user = db.collection(USERS).document(userInfo.value.uid)
        val wishListsInDB = db.collection(WISHLISTS)
        val tempWishList = mutableListOf<WishList>()

        user.get().addOnSuccessListener { doc ->
            val userFromDB = doc.toObject(User::class.java)
            //Log.v("events", "Getting events")
            Log.v(
                "i will try to fetch wishlists: ",
                userFromDB!!.wishListIdentifiers.size.toString()
            )
            if (userFromDB.wishListIdentifiers.isEmpty()) {
                userInfo.update { t ->
                    t.copy(
                        dataStateWishLists = DataStateWishLists.Empty
                    )
                }


            } else {
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
                                        wishLists = tempWishList,
                                        dataStateWishLists = DataStateWishLists.Success
                                    )
                                }
                            }

                        }.addOnFailureListener {
                            userInfo.update { t ->
                                t.copy(
                                    wishLists = tempWishList,
                                    dataStateWishLists = DataStateWishLists.Failure
                                )
                            }
                            println("Could not find wishlist")
                        }


                }
            }


        }.addOnFailureListener {
            userInfo.update { t ->
                t.copy(
                    wishLists = tempWishList,
                    dataStateWishLists = DataStateWishLists.Failure
                )
            }
            println("Could not find the user")
        }
    }

    fun getAllGiftsInWishList() {
        makeSureCorrectUIDIsUsed()
        val wishList = db.collection(WISHLISTS).document(userInfo.value.currentWishListId)
        val giftListsInDB = db.collection(GIFTS)
        val tempGiftList = mutableListOf<Gift>()
        Log.v(
            FIREBASE_SERVICE_TAG,
            "Trying to get all wishes from wishlist with id: " + userInfo.value.currentWishListId
        )
        println("Trying to get all wishes from wishlist with id: " + userInfo.value.currentWishListId)

        wishList.get().addOnSuccessListener { docWishList ->
            val wishListFromDB = docWishList.toObject(WishList::class.java)
            Log.v(
                FIREBASE_SERVICE_TAG,
                "Trying to get: " + wishListFromDB!!.giftAddressees.size.toString() + " from the db"
            )
            if (wishListFromDB.giftAddressees.isEmpty()) {
                userInfo.update { t ->
                    t.copy(
                        dataStateWishes = DataStateWishes.Empty
                    )
                }
            } else {
                for (giftIdentifier in wishListFromDB.giftAddressees) {
                    giftListsInDB.document(giftIdentifier).get().addOnSuccessListener { docGift ->
                        val gotGift = docGift.toObject(Gift::class.java)
                        tempGiftList.add(gotGift!!)
                        println("GiftList has size: " + tempGiftList.size)
                        if (tempGiftList.size == wishListFromDB.giftAddressees.size) {
                            tempGiftList.add(Gift(realWish = false))
                            Log.v(FIREBASE_SERVICE_TAG, "Trying to add the fake gift to the list ")
                            userInfo.update { t ->
                                t.copy(
                                    currentGiftList = tempGiftList,
                                    dataStateWishes = DataStateWishes.Success
                                )
                            }
                        }

                    }

                }
            }


        }


    }

    fun getSingleEvent(eventId: String) {
        val eventsInDB = db.collection(EVENTS).document(eventId)
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
        val addEvent = db.collection(EVENTS)
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
        addEvent.update(data1)
            .addOnSuccessListener { Log.d("Firestore", "Event updated successfully") }
            .addOnFailureListener { e -> Log.d("Firestore", "Fail in update", e) }

    }

    fun setCurrentEventId(id: String) {
        userInfo.update { t -> t.copy(currentEventID = id) }


    }

    fun getProfileInfoAndUpdate() {
        makeSureCorrectUIDIsUsed()
        val user = db.collection(USERS).document(userInfo.value.uid)

        user.get().addOnSuccessListener { doc ->
            val userFromDB = doc.toObject(User::class.java)
            userInfo.update { t -> t.copy(user = userFromDB!!) }
        }


    }

    fun setCurrentGift(gift: Gift) {
        userInfo.update { t -> t.copy(currentGift = gift) }


    }

    fun setCurrentWisHListId(wishListId: String) {
        userInfo.update { t -> t.copy(currentWishListId = wishListId) }


    }

    fun createGift(gift: Gift) {
        val generatedID = generateId()
        val addGift = db.collection(GIFTS)
        val data1 = hashMapOf(
            GiftHelper().ID to generatedID,
            GiftHelper().DESCRIPTION to gift.description,
            GiftHelper().LINK to gift.link,
            GiftHelper().NAME to gift.name,
            GiftHelper().PICTURE to gift.picture,
            GiftHelper().OWNER_UID to uiState.value.uid,
            GiftHelper().WISHLIST_IDS to listOf(uiState.value.currentWishListId),
            GiftHelper().REALWISH to true,
            GiftHelper().PRICE to gift.price
        )
        addGift.document(generatedID).set(data1).addOnSuccessListener {
            userInfo.update { t -> t.copy(currentGiftID = generatedID) }
            val user = db.collection(WISHLISTS).document(userInfo.value.currentWishListId)
            user.get().addOnSuccessListener { doc ->
                val specificUser = doc.toObject(WishList::class.java)
                val newList = specificUser!!.giftAddressees.toMutableList()
                newList.add(generatedID)
                db.collection(WISHLISTS).document(userInfo.value.currentWishListId)
                    .update(WishListHelper().GIFT_ADDRESSES, newList)
                    .addOnFailureListener {
                        Log.v("FirebaseService", "Could not add the gift to the wishlist")
                    }
            }


        }.addOnFailureListener {
            Log.v("FirebaseService", "Could not upload the gift properly")
        }


    }

    fun getContactToFirebaseStorage() {
        cloudStorage.getReferenceFromUrl("gs://partyplanner-7fed9.appspot.com/LnRrYf6e_400x400.jpg")


    }

    fun uploadPhoto(inputStream: InputStream): String {
        val mountainsRef = cloudStorage.reference.child("/eventPictures/" + generateId() + ".jpg")


        val uploadTask = mountainsRef.putStream(inputStream)
        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
        }.addOnSuccessListener {
            println("File has been uploaded correctly")
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
            // ...
        }
        return mountainsRef.path
    }

    //Sign out method
    fun signOut() {
        val auth = Firebase.auth
        if (auth.currentUser != null) {
            auth.signOut()
        }


    }
    //Three methods to

    fun setEventStateLoading() {
        userInfo.update { t -> t.copy(dataStateEvent = DataStateEvent.Loading) }
    }

    fun setEventWishListsStateLoading() {
        userInfo.update { t -> t.copy(dataStateWishLists = DataStateWishLists.Loading) }
    }

    fun setWishesStateLoading() {
        userInfo.update { t -> t.copy(dataStateWishes = DataStateWishes.Loading) }
    }

    fun updateUser(name: String, surname: String, description: String) {
        val locationForUpdate = db.collection(USERS)
        val userMap = hashMapOf(
            UserHelper().NAME to name,
            UserHelper().SURNAME to surname,
            UserHelper().DESCRIPTION to description
        )
        locationForUpdate.document(userInfo.value.uid).update(userMap as Map<String, Any>)
            .addOnSuccessListener {
                Log.v("makeUser", "User has been created")
            }
            .addOnFailureListener {
                Log.v("makeUser", "User has not been created")
            }

    }

    fun out(inputStream: InputStream, gift: Gift) = runBlocking {
        val picLocation = uploadPhoto(inputStream)
        gift.picture = picLocation
        createGift(gift)


    }

    fun createEventWithPic(
        pic: InputStream?,
        navController: NavHostController,
        viewModel: ViewModelOnApp,
        name: String,
        date: String,
        eventDescription: String,
        eventLocation: String,
    ) = runBlocking {
        val picLocation = uploadPhoto(inputStream = pic!!)
        createEvent(
            eventName = name,
            date = date,
            description = eventDescription,
            location = eventLocation,
            pictureString = picLocation
        )
    }


}