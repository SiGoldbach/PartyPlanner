package com.example.partyplanner.viewModel

import androidx.lifecycle.ViewModel
import com.example.partyplanner.fireBaseServices.AccountServiceIMPL
import com.example.partyplanner.fireBaseServices.dbUsed
import com.example.partyplanner.model.EventHelper
import com.example.partyplanner.model.LoginUiState
import com.example.partyplanner.model.UserHelper
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
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

                    val id: String? = auth.uid
                    if (id != null) {
                        dbCreateUser(forNavn, auth.uid!!, efterNavn, email)
                    }

                    // User has been successfully created
                } else {
                    // User has not been created
                }
            }

    }

    fun dbCreateUser(name: String, uid: String, surname: String, email: String) {
        val db = FirebaseFirestore.getInstance()

        val addNewUser = db.collection("USERS")
        val userMap = hashMapOf(
            UserHelper().EMAIl to email,
            UserHelper().NAME to name,
            UserHelper().UID to uid,
            UserHelper().SURNAME to surname,
            UserHelper().DESCRIPTION to "",
            UserHelper().EVENT_IDS to listOf<String>()
        )
        addNewUser.document(uid).set(userMap)


    }


}