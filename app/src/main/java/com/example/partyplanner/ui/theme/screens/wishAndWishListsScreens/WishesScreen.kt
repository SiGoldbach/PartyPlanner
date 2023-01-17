package com.example.partyplanner.ui.theme.screens.wishAndWishListsScreens

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.partyplanner.R
import com.example.partyplanner.model.DataStateWishes
import com.example.partyplanner.model.Gift
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.ui.theme.screens.reuseAbles.emptyLoadingScreen
import com.example.partyplanner.ui.theme.screens.reuseAbles.loadingScreen
import com.example.partyplanner.viewModel.ViewModelOnApp
import com.example.partyplanner.viewModel.ViewModelWishes
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


@Composable
fun Wishes(
    navController: NavHostController,
    viewModelOnApp: ViewModelOnApp,
    viewModelWishes: ViewModelWishes
) {
    val viewModelWishesData by viewModelWishes.uiState.collectAsState()
    val appState by viewModelOnApp.uiState.collectAsState()
    viewModelOnApp.getAllGiftsInWishList()

    if (appState.dataStateWishes == DataStateWishes.Loading) {
        loadingScreen(text = "Loader ønsker")
    }
    if (appState.dataStateWishes == DataStateWishes.Empty) {
        emptyLoadingScreen(
            text = "Det er godt nok tomt her, opret et ønske",
            buttonText = "Opret ønske"
        ) {
            navController.navigate(Destination.CreateWish.route)

        }
    }
    if (appState.dataStateWishes == DataStateWishes.Success) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "There are: " + (appState.currentGiftList.size - 1).toString() + " Gifts in this wishlist")
            Text("gs://partyplanner-7fed9.appspot.com" + viewModelWishesData.currentGift.picture)
            Text("gs://partyplanner-7fed9.appspot.com/eventPictures/ac4b1b6b-0894-46c1-99db-95031ee593bf.jpg")



            if (viewModelWishesData.popupControl) {
                Row {
                    AlertDialog(modifier = Modifier
                        .fillMaxHeight(0.6F)
                        .padding(vertical = 30.dp),
                        backgroundColor = beige,
                        onDismissRequest = {
                            viewModelWishes.disablePopUp()
                        },
                        title = { Text(text = viewModelWishesData.currentGift.name) },
                        confirmButton = {
                            Button(
                                onClick = { viewModelWishes.disablePopUp() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
                            ) {
                                Text("Opdater")
                            }
                        }

                    )
                }

            }

            LazyVerticalGrid(
                modifier = Modifier.fillMaxHeight(),
                columns = GridCells.Adaptive(minSize = 160.dp),
                // cells = GridCells.Adaptive(minSize = 160.dp),
                verticalArrangement = Arrangement.spacedBy(1.dp),
                horizontalArrangement = Arrangement.spacedBy(1.dp)
            ) {
                items(appState.currentGiftList) { item ->
                    WishesComposer(item, navController, viewModelWishes, viewModelOnApp)
                }
            }
        }
    }


}

/**
 * Here is the standard WishesComposer, now with just a default image of loading.
 * Since no picture has been loaded yet from the viewmodels apis.
 * this is similar to eventComposer
 */

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WishesComposer(
    gave: Gift,
    navController: NavHostController,
    viewModelWishes: ViewModelWishes,
    viewModelOnApp: ViewModelOnApp
) {
    val cloudStorage = Firebase
    val context: Context
    val uri3 = Uri.parse("android.resource://" + "drawable+" + "/" + R.drawable.loading_picture)
    var selectImages by remember { mutableStateOf<Uri?>(uri3) }
    val uri = "gs://partyplanner-7fed9.appspot.com" + gave.picture
    val uri2 =
        "gs://partyplanner-7fed9.appspot.com/eventPictures/ac4b1b6b-0894-46c1-99db-95031ee593bf.jpg"


    cloudStorage.storage.reference.child(gave.picture).downloadUrl.addOnSuccessListener {
        selectImages = it
    }


    if (gave.realWish) {
        Card(
            // onClick = { popupControl = true },
            border = BorderStroke(width = 2.dp, color = dustyRose),
            modifier = Modifier
                .size(width = 350.dp, height = 150.dp)
                .padding(5.dp),
            backgroundColor = beige,
            onClick = { viewModelWishes.enablePopUpAnChangeCurrentWish(gift = gave) }
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = gave.name, modifier = Modifier.padding(5.dp))
                Box(modifier = Modifier.fillMaxHeight(1F), Alignment.BottomEnd) {
                    Image(
                        painter = rememberAsyncImagePainter(model = selectImages),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        contentScale = ContentScale.Fit,
                    )

                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    ) {


                    }
                }
            }


            /**
             *  button for "add a wish"
             *  Image(
            modifier = Modifier
            .size(70.dp, 70.dp)
            .clickable(
            onClick = { navController.navigate(Destination.com.example.partyplanner.ui.theme.screens.wishAndWishListsScreens.AddWishToList.route) }
            ),
            painter = painterResource(id = R.drawable.addpresentpicture),
            contentDescription = "Tilføj ønske",
            alignment = Alignment.Center,
            )
             * */


        }
    } else {

        Card(
            modifier = Modifier
                .size(width = 350.dp, height = 150.dp)
                .padding(5.dp),
            backgroundColor = beige,
            elevation = 0.dp,

            ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.addpresentpicture),
                    contentDescription = "Denne knap tilføjer et ønske",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(100.dp, 100.dp)
                        .clickable(onClick = { navController.navigate(Destination.CreateWish.route) }),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center
                )
            }
        }
    }
}


