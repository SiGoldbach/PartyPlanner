package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.R
import com.example.partyplanner.model.DataStateWishLists
import com.example.partyplanner.model.WishList
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.ViewModelOnApp

// The mainscreen for wishlist

@Composable
fun WishlistForEvent(navController: NavController, viewModelOnApp: ViewModelOnApp) {
    val appState by viewModelOnApp.uiState.collectAsState()
    viewModelOnApp.getAllWishLists()

    if (appState.dataStateWishLists == DataStateWishLists.Loading) {
        loadingScreen(text = "Loader ønskelister")
    }
    if (appState.dataStateWishLists == DataStateWishLists.Empty) {
        emptyLoadingScreen(
            text = "Her er godt nok tomt opret en ny ønskeliste ",
            buttonText = "Lav nyt ønske"
        ) {
            navController.navigate(Destination.CreateWishlist.route)
        }
    }

    if (appState.dataStateWishLists == DataStateWishLists.Failure) {
        Text(text = "Kunne ikke hente dine ønskelister prøv igen senere")

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WishListComposerForEvent(
    wishList: WishList,
    navController: NavController,
    viewModelOnApp: ViewModelOnApp
) {
    Card(
        modifier = Modifier

            .padding(start = 5.dp, end = 5.dp),
        onClick = {
            viewModelOnApp.setCurrentWisHListId(wishList.id)
            navController.navigate(Destination.Wishes.route)
        },
        backgroundColor = dustyRose,

        ) {
        Column(
            modifier = Modifier
                .padding(start = 3.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                Arrangement.Start
            ) {

                val imageModifier = Modifier
                    .size(50.dp)
                    .padding(top = 2.dp)
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterVertically)
                Image(
                    painter = painterResource(id = R.drawable.wishlistpicture),
                    contentDescription = "Dette er ønskelisten for" + wishList.name,
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier.padding(3.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = wishList.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = "",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(alignment = Alignment.Start)
                    )

                }
            }
        }
    }
}


