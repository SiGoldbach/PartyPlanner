package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.partyplanner.R
import com.example.partyplanner.model.Gift
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose


@Composable
fun Wishes(navController: NavHostController) {
    val gift1 = Gift("Konfirmation", "Se ønskelisten her")
    val gift2 = Gift("Juleaften", "Se ønskelisten her")
    val gift3 = Gift("Fødselsdagsønsker", "Se ønskelisten her")
    val gift4 = Gift("Gaveideer", "Se ønskelisten her")
    val gift5 = Gift("Lejlighed", "Se ønskelisten her")

    val list = listOf(gift1, gift2, gift3, gift4, gift5)


    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxHeight(),
            columns = GridCells.Adaptive(minSize = 160.dp),
            // cells = GridCells.Adaptive(minSize = 160.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            items(list) { item ->
                WishesComposer(item, navController)
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
fun WishesComposer(gave: Gift, navController: NavHostController) {
    var popupControl by remember { mutableStateOf(false) }
    Card(
        // onClick = { popupControl = true },
        border = BorderStroke(width = 2.dp, color = dustyRose),
        modifier = Modifier
            .size(width = 350.dp, height = 150.dp)
            .padding(5.dp), backgroundColor = beige
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1F),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "wish-name")
            Box(modifier = Modifier.fillMaxHeight(1F), Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = R.drawable.loading_picture),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop,
                )

                Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Bottom) {

                    Button(
                        onClick = { popupControl = true },
                        colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)
                    ) {
                        Text(text = "Gå til")
                    }
                }
            }
        }
    }
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
}
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

