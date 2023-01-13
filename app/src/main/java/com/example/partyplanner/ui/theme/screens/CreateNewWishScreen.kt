package com.example.partyplanner.ui.theme.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.partyplanner.model.Gift
import com.example.partyplanner.viewModel.ViewModelOnApp

@Composable
fun CreateNewWIsh(viewModelOnApp: ViewModelOnApp, navHostController: NavHostController) {

    var selectImages by remember { mutableStateOf<Uri?>(null) }

    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            selectImages = uri


        }
    Column(modifier = Modifier.fillMaxSize()) {
        StandardButton(output = "Vælg et billede til din gave") {
            galleryLauncher.launch("image/*")

        }
        if (selectImages != null) {
            Image(
                painter = rememberImagePainter(data = selectImages),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp, 8.dp)
                    .size(200.dp)
                    .clickable {

                    }
            )
        }

    }


}

fun createWIshAndGoBack(gift: Gift, viewModelOnApp: ViewModelOnApp) {
    viewModelOnApp.createGift(gift)

}