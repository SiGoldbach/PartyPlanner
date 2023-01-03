package com.example.partyplanner.viewModel

import com.example.partyplanner.model.OnAppModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelOnApp {
    private val userInfo = MutableStateFlow(OnAppModel("TEST"))
    val uiState: StateFlow<OnAppModel> = userInfo.asStateFlow()


    private val db = FirebaseFirestore.getInstance()


    fun createEvent(eventName: String) {
        val cities = db.collection("events")

        val data1 = hashMapOf(
            "name" to eventName,

            )
        cities.document("$eventName something new").set(data1)
    }


}