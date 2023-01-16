package com.example.partyplanner.ui.theme.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.partyplanner.model.Gift
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.InputStream

@Composable
fun CreateNewWIsh(viewModelOnApp: ViewModelOnApp, navHostController: NavHostController) {
    val context = LocalContext.current
    val uri = Uri.parse("res/drawable-tvdpi/adidas_shoe.PNG")
    var selectImages by remember { mutableStateOf<Uri?>(uri) }
    var wishName by remember { mutableStateOf(TextFieldValue("")) }
    var wishPrice by remember { mutableStateOf(TextFieldValue("")) }
    val cloudStorage = Firebase.storage
    var pic: InputStream?

    cloudStorage.getReferenceFromUrl("gs://partyplanner-7fed9.appspot.com/LnRrYf6e_400x400.jpg").downloadUrl.addOnSuccessListener {
        selectImages = it
    }


    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uriFromSelector ->
            selectImages = uriFromSelector



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
        Button(onClick = { uploadPic(viewModelOnApp) }) {
            Text(text = "Try to upload photo")

        }


    }


}

fun createWIshAndGoBack(gift: Gift, viewModelOnApp: ViewModelOnApp) {
    viewModelOnApp.createGift(gift)

}

fun uploadPic(viewModelOnApp: ViewModelOnApp) {
}