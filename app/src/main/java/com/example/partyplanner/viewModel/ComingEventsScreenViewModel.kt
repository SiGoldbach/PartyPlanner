package com.example.partyplanner.viewModel

import androidx.lifecycle.ViewModel
import com.example.partyplanner.model.ComingEventsModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Should not include data itself should only include other data objects.
 */
class ComingEventsScreenViewModel : ViewModel() {
    private val gameUiState = MutableStateFlow(ComingEventsModel())
    val uiState: StateFlow<ComingEventsModel> = gameUiState.asStateFlow()

    var db = FirebaseFirestore.getInstance()



}