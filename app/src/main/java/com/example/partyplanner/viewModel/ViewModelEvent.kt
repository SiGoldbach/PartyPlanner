package com.example.partyplanner.viewModel

import androidx.lifecycle.ViewModel
import com.example.partyplanner.model.Begivenhed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelEvent : ViewModel() {
    private val gameUiState = MutableStateFlow(Begivenhed())
    val uiState: StateFlow<Begivenhed> = gameUiState.asStateFlow()

}