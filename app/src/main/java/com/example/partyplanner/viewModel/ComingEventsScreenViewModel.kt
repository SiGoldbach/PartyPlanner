package com.example.partyplanner.viewModel

import androidx.lifecycle.ViewModel
import com.example.partyplanner.model.ComingEventsModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Should not include data itself should only include other data objects.
 */
class ComingEventsScreenViewModel : ViewModel() {
    private val gameUiState = MutableStateFlow(ComingEventsModel())
    val uiState: StateFlow<ComingEventsModel> = gameUiState.asStateFlow()

    private var db = FirebaseFirestore.getInstance()
    fun values() {
        val saved = db.collection("/TESTCOLLECTION").document("krw8Noq59kNBa6fgay7u")

        val cities = db.collection("cities")

        val data1 = hashMapOf(
            "name" to "San Francisco",
            "state" to "CA",
            "country" to "USA",
            "capital" to false,
            "population" to 860000,
            "regions" to listOf("west_coast", "norcal")
        )
        cities.document("SF").set(data1)
    }


}