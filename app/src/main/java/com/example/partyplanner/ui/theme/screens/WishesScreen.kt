package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.partyplanner.R
import com.example.partyplanner.model.Gift
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp
import com.example.partyplanner.viewModel.ViewModelWishes


@Composable
fun Wishes(
    navController: NavHostController,
    viewModelOnApp: ViewModelOnApp,
    viewModelWishes: ViewModelWishes
) {
    val viewModelWishesData by viewModelWishes.uiState.collectAsState()
    val appState by viewModelOnApp.uiState.collectAsState()
    viewModelOnApp.getAllGiftsInWishList()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "There are: " + (appState.currentGiftList.size - 1).toString() + " Gifts in this wishlist")

        if (viewModelWishesData.popupControl) {
                Row(
                ) {
                    AlertDialog(
                        modifier = Modifier.fillMaxHeight().padding(vertical = 30.dp),
                        backgroundColor = beige,
                        onDismissRequest = {
                            viewModelWishes.disablePopUp()
                        },
                        title = { Text(text = viewModelWishesData.currentGift.name) },
                        text = { Text(viewModelWishesData.currentGift.description) },
                        confirmButton = {
                            Button(
                                onClick = { viewModelWishes.disablePopUp() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose),
                            ) {
                                Text("Opdater")
                            }
                        }, dismissButton = {
                            Button(
                                onClick = { viewModelWishes.disablePopUp() },
                                colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)
                            ) {
                                Text("Slet")
                            }
                        }

                    )
                }

        }

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxHeight(),
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

/**
 * Here is the standard WishesComposer, now with just a default image of loading.
 * Since no picture has been loaded yet from the viewmodels apis.
 * this is similar to eventComposer
 */

@Composable
fun WishesComposer(
    gave: Gift,
    navController: NavHostController,
    viewModelWishes: ViewModelWishes,
    viewModelOnApp: ViewModelOnApp
) {

    if (gave.realWish) {
        Card(
            // onClick = { popupControl = true },
            border = BorderStroke(width = 2.dp, color = dustyRose),
            modifier = Modifier
                .size(width = 350.dp, height = 150.dp)
                .padding(5.dp), backgroundColor = beige
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = gave.name, modifier = Modifier.padding(5.dp))
                Box(modifier = Modifier.fillMaxHeight(1F), Alignment.BottomEnd) {
                    Image(
                        painter = painterResource(id = R.drawable.loading_picture),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                    )

                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    ) {

                        Button(
                            onClick = { viewModelWishes.enablePopUpAnChangeCurrentWish(gift = gave) },
                            colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)
                        ) {
                            Text(text = "Gå til")
                        }
                    }
                }
            }


            /**
             *  button for "add a wish"
             *  Image(
            modifier = Modifier
            .size(70.dp, 70.dp)
            .clickable(
            onClick = { navController.navigate(Destination.AddWishToList.route) }
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
                        .clickable(
                            onClick = { createDummyEvent(viewModelOnApp = viewModelOnApp) }
                        ),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center
                )
            }


        }


        //    Spacer(modifier = Modifier.h)


    }
}

fun createDummyEvent(viewModelOnApp: ViewModelOnApp) {
    viewModelOnApp.createGift(Gift(realWish = true, name = "MyGift"))


}

// """"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
/*  if (popupControl) {
      Popup(
          alignment = Alignment.Center,
      ) {

      }


// What has to be shown in the pop-up.
Card(
    border = BorderStroke(width = 2.dp, color = Color.Black),
    onClick = { popupControl = false },
    modifier = Modifier
        .size(width = 350.dp, height = 500.dp)
        .padding(5.dp),
    backgroundColor = Color.Cyan,
) {
    Text("hello")
    Button(onClick = { popupControl = false }) {
        Text("Close")
    }
}
}
} */

/*
@Composable
fun PopupWindow() {
    var popupControl by remember { mutableStateOf(false) }
    val buttonTitle by remember { mutableStateOf("close") }

    Column(modifier = Modifier
        .size(350.dp, 500.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        Button(modifier = Modifier.fillMaxWidth(), onClick = { popupControl = false }) {
            if (popupControl == false) {
                buttonTitle.value = "testtest"
            }
        }
    }
}
*/

