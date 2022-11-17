package com.example.partyplanner.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.partyplanner.R
import com.example.partyplanner.ui.theme.beige
import com.example.partyplanner.ui.theme.dustyRose
import com.example.partyplanner.viewModel.Event
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun MyEventScreen(event: Event, navController: NavController) {
    Column() {

        //Top picture with event name
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                // .size(width = 350.dp, height = 300.dp)
                .padding(10.dp),
            backgroundColor = beige
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1F),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(modifier = Modifier.fillMaxHeight(1F)) {
                    Image(
                        // billede her skal komme fra event.
                        painter = painterResource(id = R.drawable.loading_picture),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                    )
                }


            }


        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Her skal Event name komme fra "event".
                // Gør text større, tykkere og mere overskrift-agtigt.
                Text(
                    text = event.name,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp, color = Color.Black,
                    modifier = Modifier
                )
                // Description text here comes from "event".
                Text(
                    text = event.dato,
                    fontStyle = FontStyle.Normal

                )
                Text(
                    text = event.description,
                    fontStyle = FontStyle.Normal
                )
            }
        }
    }
}

// InformationText
/*   Box() {
       Card(
           border = BorderStroke(width = 2.dp, color = dustyRose),
           modifier = Modifier
               .fillMaxWidth()
               .height(250.dp)
               .padding(10.dp), backgroundColor = beige
       ) {
           Column(
               modifier = Modifier
                   .fillMaxWidth()
                   .fillMaxHeight(1F),
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Text(text = "28-09-2022")
               Spacer(modifier = Modifier.height(5.dp))
               Text(text = "hey")
           }
       }
   } */