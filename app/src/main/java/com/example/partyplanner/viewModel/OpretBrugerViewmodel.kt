package com.example.partyplanner.viewModel

import androidx.lifecycle.ViewModel
import com.example.partyplanner.fireBaseServices.AccountServiceIMPL
import com.example.partyplanner.model.LoginUiState
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class OpretBrugerViewmodel : ViewModel() {
    private val accountService = AccountServiceIMPL()
    private var uiState = MutableStateFlow(LoginUiState())
    val state: StateFlow<LoginUiState> = uiState.asStateFlow()


    private fun createDummyUser() {
        //DUMMY METHOD THAT GETS CALLED INSTEAD OF SOMETHING ELSE

    }

    private fun createUser() {
        accountService.authenticate(uiState.value.email, uiState.value.password) { error ->
            if (error == null) {
            }
        }


    }

    fun putCredentialsAndCreateUser(
        forNavn: String,
        efterNavn: String,
        email: String,
        kodeord: String
    ) {
        uiState.update { state -> state.copy(email = email, password = kodeord) }
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(uiState.value.email, uiState.value.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // User has been successfully created
                } else {
                    // User has not been created
                }
            }

    }


}