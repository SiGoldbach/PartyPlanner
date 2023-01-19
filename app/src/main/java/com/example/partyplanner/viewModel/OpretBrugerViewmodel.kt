package com.example.partyplanner.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.partyplanner.fireBaseServices.AccountServiceIMPL
import com.example.partyplanner.model.LoginUiState
import com.example.partyplanner.model.UserHelper
import com.example.partyplanner.naviagion.Destination
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
        internalNavHostController: NavHostController,
        forNavn: String,
        efterNavn: String,
        email: String,
        kodeord: String,
    ) {


        uiState.update { state -> state.copy(email = email, password = kodeord) }
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(uiState.value.email, uiState.value.password)
            .addOnSuccessListener { task ->
                val id: String? = auth.uid
                if (id == null) {
                    Log.v("makeUser", "id is null")
                }
                if (id != null) {
                    dbCreateUser(forNavn, auth.uid!!, efterNavn, email)

                }
                auth.signInWithEmailAndPassword(uiState.value.email, uiState.value.password)
                    .addOnSuccessListener {
                        Log.v(
                            "makeUser",
                            "Now the user account is created and the user should be signed in. "
                        )
                        internalNavHostController.navigate(Destination.OnMainAppStartScreen.route)

                    }.addOnFailureListener {
                        Log.v(
                            "makeUser",
                            "Could not login on the user that was created 1 second ago. "
                        )
                    }

                // User has been successfully created
            }
        // User has not been created
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
            UserHelper().EVENT_IDS to listOf<String>(),
            UserHelper().PHONE_NUMBER to ""
        )
        addNewUser.document(uid).set(userMap)
            .addOnSuccessListener {
                Log.v("makeUser", "User has been created")
            }
            .addOnFailureListener {
                Log.v("makeUser", "User has not been created")
            }


    }
}


