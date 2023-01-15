package com.example.partyplanner.ui.theme.screens

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.partyplanner.fireBaseServices.generateId
import com.example.partyplanner.model.Gift
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import java.io.FileInputStream
import kotlin.coroutines.coroutineContext

@Composable
fun CreateNewWIsh(viewModelOnApp: ViewModelOnApp, navHostController: NavHostController) {
    val uri = Uri.parse("res/drawable-tvdpi/adidas_shoe.PNG")
    var selectImages by remember { mutableStateOf<Uri?>(uri) }
    var wishName by remember { mutableStateOf(TextFieldValue("")) }
    var wishPrice by remember { mutableStateOf(TextFieldValue("")) }
    val cloudStorage = Firebase.storage
    var imageView = ImageView(null)

    cloudStorage.getReferenceFromUrl("gs://partyplanner-7fed9.appspot.com/LnRrYf6e_400x400.jpg").downloadUrl.addOnSuccessListener {
        selectImages = it
    }


    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            selectImages = uri
            imageView.setImageURI(uri)


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
        Button(onClick = { uploadPic(imageView) }) {
            Text(text = "Try to upload photo")

        }


    }


}

fun createWIshAndGoBack(gift: Gift, viewModelOnApp: ViewModelOnApp) {
    viewModelOnApp.createGift(gift)

}

fun uploadPic(imageView: ImageView) {
    val cloudStorage = Firebase.storage.reference
    cloudStorage.child("/eventPictures" + generateId())
    val bitmap = (imageView.drawable as BitmapDrawable).bitmap
    val baos = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
    val data = baos.toByteArray()

    val uploadTask = cloudStorage.putBytes(data)
    uploadTask.addOnFailureListener {
        // Handle unsuccessful uploads
    }.addOnSuccessListener { taskSnapshot ->
        // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
        // ...
    }


}