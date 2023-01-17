package com.example.partyplanner.viewModel

import androidx.lifecycle.ViewModel
import com.example.partyplanner.model.Gift
import com.example.partyplanner.model.WishesModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelWishes : ViewModel() {

    private val userInfo =
        MutableStateFlow(
            WishesModel(
                currentGift = Gift(realWish = true)
            )
        )
    val uiState: StateFlow<WishesModel> = userInfo.asStateFlow()

    private fun setCurrentGift(gift: Gift) {
        userInfo.update { t -> t.copy(currentGift = gift) }


    }

    fun enablePopUpAnChangeCurrentWish(gift: Gift) {
        println("Enabling popUpBox")
        setCurrentGift(gift = gift)
        userInfo.update { t ->
            t.copy(
                popupControl = true,
                testCounter = uiState.value.testCounter + 1
            )
        }


    }

    fun disablePopUp() {
        println("Disabling popUpBox")
        userInfo.update { t ->
            t.copy(popupControl = false)
        }

    }
}