package com.example.partyplanner

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import com.example.partyplanner.ui.theme.dustyRose

//I am changing the name to "Dependency injection since different screens need,
//Different tittles.
@Composable
fun AppBar(
    stringResource: String,
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource)
        },
        backgroundColor = dustyRose,
        contentColor = androidx.compose.ui.graphics.Color.White,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Filled.Menu, contentDescription = "Toggle drawer"
                )
            }
        }
    )
}

