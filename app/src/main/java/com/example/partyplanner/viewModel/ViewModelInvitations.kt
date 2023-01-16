package com.example.partyplanner.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.partyplanner.model.InvitationModel
import com.example.partyplanner.model.Invitations
import com.example.partyplanner.model.LoginUiState
import com.example.partyplanner.ui.theme.screens.InvitationScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelInvitations : ViewModel() {
    private var uiState = MutableStateFlow(InvitationModel( ))
    val state: StateFlow<InvitationModel> = uiState.asStateFlow()



    fun addInviteToList(inviteItem: Invitations) {
        uiState.update { state -> state.copy(listinvitation = (state.listinvitation + inviteItem) as MutableList<Invitations>) }
    }


    fun removeInviteItem(inviteItem: Invitations) {
        //Remove item from list
        uiState.update { state -> state.copy(listinvitation = (state.listinvitation - inviteItem) as MutableList<Invitations>) }


    }


    fun markAsComplete(inviteItem: Invitations, value: Boolean) {
        var localList = uiState.value.listinvitation
        localList.find { it == inviteItem }?.isComplete = value
        uiState.update { t->t.copy(listinvitation = localList) }


    }
}