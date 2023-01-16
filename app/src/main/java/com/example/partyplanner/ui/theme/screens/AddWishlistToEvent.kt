package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.partyplanner.R
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.model.WishList
import com.example.partyplanner.naviagion.Destination
import com.example.partyplanner.viewModel.ViewModelOnApp

// The screen for adding a wishlist to an event.

@Composable
fun Wishlist2(navController: NavController, viewModelOnApp: ViewModelOnApp) {
    val appState by viewModelOnApp.uiState.collectAsState()
    viewModelOnApp.getAllWishLists()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Ønskelister",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(
                )

        )

        Divider(color = Color.Black, thickness = 0.5.dp)

        Spacer(modifier = Modifier.height(15.dp))

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxHeight(0.7F),
            columns = GridCells.Adaptive(minSize = 200.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)

        ) {
            items(appState.wishLists) { item ->
                WishListComposer2(item, navController, viewModelOnApp)
            }

        }

    }


    //   Row(modifier = Modifier.fillMaxSize(),
    // horizontalArrangement = Arrangement.Center,
    // verticalAlignment = Alignment.Bottom) {
    //   }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WishListComposer2(
    wishList: WishList,
    navController: NavController,
    viewModelOnApp: ViewModelOnApp
) {
    Card(
        modifier = Modifier

            .padding(start = 5.dp, end = 5.dp),
        onClick = {
            viewModelOnApp.setCurrentWisHListId(wishList.id)
            navController.navigate(Destination.MyEventEditScreen.route)
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


