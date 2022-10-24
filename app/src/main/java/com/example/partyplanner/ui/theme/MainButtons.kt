package com.example.partyplanner.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {

    var count = 0
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(200.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            count++

        }, colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)) {
            Text(text = "Simple button")
            Spacer(
                modifier = Modifier
                    .width(50.dp)
                    .height(30.dp)
            )
        }
        Button(onClick = {
            count++

        }) {
            Text(text = "Simple button1")
        }
        Button(onClick = {
            count++

        }) {
            Text(text = "Simple button2")
        }


    }


}


