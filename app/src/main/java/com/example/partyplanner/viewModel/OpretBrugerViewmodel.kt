package com.example.partyplanner.viewModel

import androidx.lifecycle.ViewModel
import com.example.partyplanner.fireBaseServices.AccountServiceIMPL
import com.example.partyplanner.model.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class OpretBrugerViewmodel : ViewModel() {
    private val accountService = AccountServiceIMPL()
    private var uiState = MutableStateFlow(LoginUiState())
    val state: StateFlow<LoginUiState> = uiState.asStateFlow()


    fun putCredentialsAndCreateUser(email: String, password: String) {
        uiState.update { state -> state.copy(email = email, password = password) }

    }

    private fun createDummyUser() {
        //DUMMY METHOD THAT GETS CALLED INSTEAD OF SOMETHING ELSE

    }

    private fun createUser() {
        accountService.authenticate(uiState.value.email, uiState.value.password) { error ->
            if (error == null) {
            }
        }


    }


}