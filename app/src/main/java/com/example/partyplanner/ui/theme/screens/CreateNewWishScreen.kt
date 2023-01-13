package com.example.partyplanner.ui.theme.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.partyplanner.model.Gift
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp

@Composable
fun CreateNewWIsh(viewModelOnApp: ViewModelOnApp, navHostController: NavHostController) {

    var selectImages by remember { mutableStateOf<Uri?>(null) }
    var wishName by remember { mutableStateOf(TextFieldValue("")) }
    var wishPrice by remember { mutableStateOf(TextFieldValue("")) }


    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            selectImages = uri


        }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(standardDP),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(standardDP))

        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = wishName,
            label = { Text(text = "Ønskeliste navn", color = dustyRose) },
            onValueChange = { wishName = it },
            modifier = Modifier.width(width = 350.dp)


        )
        Spacer(modifier = Modifier.height(standardDP))

        OutlinedTextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = dustyRose),
            value = wishPrice,
            label = { Text(text = "Ønskets pris", color = dustyRose) },
            onValueChange = { wishPrice = it },
            modifier = Modifier.width(width = 350.dp)


        )
        Spacer(modifier = Modifier.height(standardDP))

        StandardButton(output = "Vælg et billede til din gave") {
            galleryLauncher.launch("image/*")

        }
        Card(modifier = Modifier.size(200.dp), backgroundColor = beige) {
            if (selectImages != null) {
                Image(
                    painter = rememberImagePainter(data = selectImages),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clickable {

                        }
                )
            }
        }


    }


}

fun createWIshAndGoBack(gift: Gift, viewModelOnApp: ViewModelOnApp) {
    viewModelOnApp.createGift(gift)

}