package com.example.partyplanner.viewModel

import androidx.lifecycle.ViewModel
import com.example.partyplanner.model.Gift
import com.example.partyplanner.model.HelpModel
import com.example.partyplanner.model.OnAppModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ViewModelHelp : ViewModel() {
    private val helpInfo = MutableStateFlow(HelpModel())
    val helpInfoState: StateFlow<HelpModel> = helpInfo.asStateFlow()


    fun updateTextValues(
        buttonText: String = "",
        descriptionText: String = "",
        title: String = ""
    ) {
        helpInfo.update { t ->
            t.copy(
                buttonText = buttonText,
                descriptionText = descriptionText,
                title = title
            )
        }

    }

    fun setPopupTrue() {
        helpInfo.update { t ->
            t.copy(
                dialogOpener = true
            )
        }

    }

    fun setPopupFalse() {
        helpInfo.update { t ->
            t.copy(
                dialogOpener = false
            )
        }

    }

}