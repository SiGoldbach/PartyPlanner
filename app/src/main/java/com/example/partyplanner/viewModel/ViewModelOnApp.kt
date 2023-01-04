package com.example.partyplanner.viewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.partyplanner.model.Event
import com.example.partyplanner.model.EventsDataState
import com.example.partyplanner.model.OnAppModel
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
        userInfo.update { t -> t.copy(uid = "TEST2") }
    }

    private val db = FirebaseFirestore.getInstance()

    fun createEvent(eventName: String, date: String, description: String): Boolean {
        var boolean = false
        val addEvent = db.collection("DB").document(uiState.value.uid).collection("events")
        val data1 = hashMapOf(
            "name" to eventName,
            "date" to date,
            "description" to description,
            "Participants" to 0,
            "totalInvites" to 0

        )
        addEvent.document(eventName).set(data1)
            .addOnSuccessListener { boolean = true }.addOnFailureListener { println("Failure") }
        return boolean
    }


    fun updateEventList() {
        getAllEvents(uiState.value.uid)


    }



    fun getAllEvents(uid: String) {

        val events = db.collection("DB").document(uid).collection("events")
        val tempEventsList = mutableListOf<Event>()
        allEventsResponse.value = EventsDataState.Loading

        events.get().addOnSuccessListener { docs ->
                for (doc in docs) {
                    val event = doc.toObject(Event::class.java)
                    Log.v("events", event.name)
                    event.name
                    event.date
                    if (!tempEventsList.add(event)) {
                        Log.v("Events", "Element was not added for some retarded reason")
                    }
                    Log.v("Events", tempEventsList.size.toString() + " List has size ")


                }
            userInfo.update { t -> t.copy(events = tempEventsList) }



        }.addOnFailureListener {
                allEventsResponse.value = EventsDataState.Failure("FAILURE")

            }

        Log.v("Events", tempEventsList.size.toString() + " List has size in the end ")



    }


}