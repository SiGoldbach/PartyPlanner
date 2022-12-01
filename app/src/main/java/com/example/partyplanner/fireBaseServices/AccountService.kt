package com.example.partyplanner.fireBaseServices

interface AccountService {
    fun createAnonymousAccount(onResult: (Throwable?)->Unit)
    fun authenticate(email: String, password: String, onResult: (Throwable?) -> Unit)
    fun linkAccount(email: String, password: String, onResult: (Throwable?) -> Unit)
}