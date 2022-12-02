package com.example.partyplanner.model

import androidx.compose.ui.graphics.vector.ImageVector
/**
 * This here is for the scaffold and will not really be used with a viewmodel
 */
data class MenuItem(
    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: ImageVector
)
