package com.example.partyplanner.ui.theme
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@SuppressLint("SuspiciousIndentation")
@Composable
fun Navigation() {
    val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            ComingEvents(navController = navController)
        }
    }
}

@Composable
fun EventScreen(navController: NavController) {
Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 50.dp)
    ) {
        Button(onClick = {
            navController.navigate(Screen.EventScreen.route)
        }, modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = dustyRose)
        ) {
            Text(text = "Events", color = Color.White, fontSize = 20.sp)
        }
    }
}