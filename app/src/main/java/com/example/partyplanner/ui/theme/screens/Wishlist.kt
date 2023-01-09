package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.Image
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
import com.example.partyplanner.model.Gift

// The mainscreen for wishlist

@Composable
fun Wishlist(navController: NavController) {
    val gift1 = Gift("Konfirmation", "Se ønskelisten her")
    val gift2 = Gift("Juleaften", "Se ønskelisten her")
    val gift3 = Gift("Fødselsdagsønsker", "Se ønskelisten her")
    val gift4 = Gift("Gaveideer", "Se ønskelisten her")
    val gift5 = Gift("Lejlighed", "Se ønskelisten her")


    val list = listOf(gift1, gift2, gift3, gift4, gift5)

    Column {
        Text(
            text = "Ønskeliste",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(
                    //Align "Wishlist" text in center of screen
                )

        )

        Divider(color = Color.Black, thickness = 0.5.dp)

        Spacer(modifier = Modifier.height(15.dp))

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxHeight(),
            columns = GridCells.Adaptive(minSize = 200.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp)

        ) {
            items(list) { item ->
                WishListComposer(item, navController)
            }

        }

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxHeight(),
            columns = GridCells.Adaptive(minSize = 160.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            items(list) { item ->
                WishListComposer(item, navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WishListComposer(gift: Gift, navController: NavController) {
    Card(
        modifier = Modifier

            .padding(start = 5.dp, end = 5.dp),
        onClick = {/* TODO */ },
        backgroundColor = dustyRose,

        ) {
        Column(
            modifier = Modifier
                .padding(start = 3.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.Start
            ) {

                val imageModifier = Modifier
                    .size(50.dp)
                    .padding(top = 2.dp)
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterVertically)
                Image(
                    painter = painterResource(id = R.drawable.attending_picture),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = gift.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = gift.description,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(alignment = Alignment.Start)
                    )

                }
            }
            /*
    *  ADD A "Add wish-list" button. Noget ala nedenstående.
    * Button(onClick = { navController.navigate(Destination.AddWishToList.route) })
        {
            Image(
                painter = painterResource(id = R.drawable.addpresentpicture),
                contentDescription = "Tilføj ønskeliste"
            )
    }
    */

        }
    }
}


