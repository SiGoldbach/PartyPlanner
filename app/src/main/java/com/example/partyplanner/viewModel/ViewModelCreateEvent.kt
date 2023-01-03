package com.example.partyplanner.viewModel

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class ViewModelCreateEvent : ViewModel() {
    private var db = FirebaseFirestore.getInstance()


    fun createEvent(eventName: String) {
        val cities = db.collection("events")

        val data1 = hashMapOf(
            "name" to eventName,

            )
        cities.document("$eventName something new").set(data1)
    }

}

