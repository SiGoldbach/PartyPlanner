package com.example.partyplanner.viewModel

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

class ViewModelOnApp : ViewModel() {
    private val userInfo =
        MutableStateFlow(
            OnAppModel(
                "TEST2", event = Event("fault", "fault", "fault"), "EMPTY",
                listOf()
            )
        )
    val uiState: StateFlow<OnAppModel> = userInfo.asStateFlow()

    val allEventsResponse: MutableState<EventsDataState> = mutableStateOf(EventsDataState.Empty)


    private val db = FirebaseFirestore.getInstance()


    fun createEvent(eventName: String, date: String, description: String): Boolean {
        var boolean = false
        val addEvent = db.collection("DB").document(uiState.value.uid).collection("events")
        val data1 = hashMapOf(
            "name" to eventName,
            "date" to date,
            "description" to description,
            "Participants" to 0

        )
        addEvent.document(eventName).set(data1)
            .addOnSuccessListener { boolean = true }.addOnFailureListener { println("Failure") }
        return boolean
    }

    fun setCurrentEvent() {

    }

    private fun getAllEvents() {
        val events = db.collection("DB").document(uiState.value.uid).collection("events")
        val tempEventsList = mutableListOf<Event>()
        allEventsResponse.value = EventsDataState.Loading

        events.get().addOnSuccessListener { docs ->
            for (doc in docs) {
                val event = doc.toObject(Event::class.java)
                tempEventsList.add(event)

            }

        }.addOnFailureListener {
            allEventsResponse.value=EventsDataState.Failure("FAILURE")

        }
    }


}