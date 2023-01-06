package com.example.partyplanner.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.partyplanner.model.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelOnApp : ViewModel() {

    private val allEventsResponse: MutableState<EventsDataState> =
        mutableStateOf(EventsDataState.Empty)

    private val userInfo =
        MutableStateFlow(
            OnAppModel(
            )
        )
    val uiState: StateFlow<OnAppModel> = userInfo.asStateFlow()


    init {
        val auth = FirebaseAuth.getInstance()
        userInfo.update { t ->
            t.copy(
                uid = auth.uid!!
            )
        }
    }

    private val db = FirebaseFirestore.getInstance()

    fun createEvent(eventName: String, date: String, description: String): Boolean {
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
            EventHelper().LOCATION to "EMPTY",
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
                    var newList = specificUser!!.eventIdentifiers.toMutableList()
                    newList.add(generatedID)
                    specificUser.eventIdentifiers = newList
                    val userMap = hashMapOf(
                        UserHelper().EMAIl to specificUser.email,
                        UserHelper().NAME to specificUser.name,
                        UserHelper().UID to specificUser.uid,
                        UserHelper().SURNAME to specificUser.surname,
                        UserHelper().DESCRIPTION to specificUser.description,
                        UserHelper().EVENT_IDS to specificUser.eventIdentifiers,
                        UserHelper().PHONE_NUMBER to specificUser.phoneNumber,
                        UserHelper().WISHlIST_IDENTIFIERS to specificUser.wishListIdentifiers
                    )
                    db.collection("USERS").document(userInfo.value.uid).set(userMap)
                }


            }.addOnFailureListener { println("Failure") }
        return boolean
    }


    fun updateEventList() {
        getAllEvents()


    }


    private fun getAllEvents() {

        val events = db.collection("DB").document(uiState.value.uid).collection("events")
        val tempEventsList = mutableListOf<Event>()
        allEventsResponse.value = EventsDataState.Loading

        events.get().addOnSuccessListener { docs ->
            for (doc in docs) {
                // val event = doc.toObject(Event::class.java)
                // Log.v("events", event.name)
                //  if (!tempEventsList.add(event)) {
                //    Log.v("Events", "Element was not added for some retarded reason")
                //   }


            }
            Log.v("Events", tempEventsList.size.toString() + " List has size ")
            if (tempEventsList.size == 0) {
                userInfo.update { t ->
                    t.copy(
                        events = tempEventsList,
                        eventsDataState = EventsDataState.Empty
                    )
                }
            } else {
                userInfo.update { t ->
                    t.copy(
                        events = tempEventsList,
                        eventsDataState = EventsDataState.Success(tempEventsList)
                    )
                }
            }


        }.addOnFailureListener {
            userInfo.update { t ->
                t.copy(
                    events = tempEventsList,
                    eventsDataState = EventsDataState.Failure("Error Finding events")
                )
            }

        }


    }

    /**
     * This updates the whole event and should be fine for this project,
     * Maybe in the future some changes are so common values might be changed one at a time.
     */
    fun updateEventValues(event: Event) {
        val addEvent = db.collection("DB").document(uiState.value.uid).collection("events")
            .document(event.name)
        val data1 = hashMapOf(
            EventHelper().NAME to event.name,
            EventHelper().DATE to event.date,
            EventHelper().DESCRIPTION to event.description,
            EventHelper().PARTICIPANTS to event.participants,
            EventHelper().TOTAL_INVITES to event.description
        )
        addEvent.set(data1)
            .addOnSuccessListener { Log.d("Firestore", "Event updated successfully") }
            .addOnFailureListener { e -> Log.d("Firestore", "Fail in update", e) }

    }

    fun setCurrentEventId(id: String) {
        userInfo.update { t -> t.copy(currentEventID = id) }


    }


}