package com.example.partyplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.partyplanner.ui.theme.*
import com.example.partyplanner.ui.theme.screens.MyEventScreen
import com.example.partyplanner.ui.theme.screens.OpretBruger
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

/**
 * When testing change the method called under the **ComposeTheme
 * Link to video used for google authentication.
 * https://www.youtube.com/watch?v=dPeS92y4gRs&ab_channel=DeveloperChunk
 */


class MainActivity : ComponentActivity() {
    companion object {
        const val SIGN_IN = 100
    }
    private lateinit var mAuth:FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //firebase auth instance
        mAuth= FirebaseAuth.getInstance()

        //Configure google sign in

        val googleSignInBUilder= GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(androidx.compose.ui.R.string.default_error_message))
            .requestEmail()
            .build()


        setContent {
            val navController = rememberNavController()
            PartyPlannerTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = dustyRose,
                        darkIcons = false
                    )
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = beige
                ) {
                }
                //Change here
                val navController = rememberNavController()
                //TopOfScreenReusable(navController = navController)
                val a = com.example.partyplanner.model.Event(
                    "Thomas bryllup",
                    "22/08/22",
                    "Vi holder bryllup fordi vi bliver gift"
                )
                OpretBruger(navController = navController)
                //MyEventScreen(a, navController = navController)
            }
        }
    }

    //I have made some changes here to test the navigation
    @Composable
    fun NavigationAppHost(navController: NavHostController) {
        val ctx = LocalContext.current

        NavHost(navController = navController, startDestination = Destination.Event.route) {
            composable(Destination.Event.route) { TopOfScreenReusable(navController) }
            composable(Destination.NewEvent.route) { TopOfScreenReusable2(navController) }
            composable(Destination.TestScreen.route) { TestScreen(navController) }
            /*composable(Destination.Detail.route) { backStackEntry ->
                val elementId = backStackEntry.arguments?.getString("elementId")
                if(elementId == null){
                    Toast.makeText(ctx, "No elementId found", Toast.LENGTH_SHORT).show()
                } else  {
                    DetailScreen(elementId = elementId.toInt())
                }*/

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PartyPlannerTheme {
            val navController = rememberNavController()
        }
    }
}

