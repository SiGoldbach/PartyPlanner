package com.example.partyplanner

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import com.example.partyplanner.ui.theme.screens.ComingEvents
import com.example.partyplanner.ui.theme.screens.OpretBruger
import com.example.partyplanner.ui.theme.screens.Wishlist
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider


/**
 * When testing change the method called under the **ComposeTheme
 * Link to video used for google authentication.
 * https://www.youtube.com/watch?v=dPeS92y4gRs&ab_channel=DeveloperChunk
 */


class MainActivity : ComponentActivity() {
    companion object {
        const val SIGN_IN = 100
    }

    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //firebase auth instance
        mAuth = FirebaseAuth.getInstance()

        //Configure google sign in
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(androidx.compose.ui.R.string.default_error_message))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)



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
                //After these side effects the app will either begin on coming events or login screen
                OpretBruger(navController = navController)
                //Change here
                //TopOfScreenReusable(navController = navController)
                val a = com.example.partyplanner.model.Event(
                    "Thomas bryllup",
                    "22/08/22",
                    "Vi holder bryllup fordi vi bliver gift"
                )
                //OpretBruger(navController = navController)
                //Wishlist(navController = navController)
                //MyEventScreen(a, navController = navController)
            }
        }

    }

    private fun signIn() {
        println("Getting to signInLL")
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, SIGN_IN)

    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val exception = task.exception
            if (task.isSuccessful) {
                try {
                    //Google sign in was succesfull
                    val account = task.getResult(ApiException::class.java)!!
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: java.lang.Exception) {
                    Log.d("SignIn", "Sign in failed ")
                }
            } else {
                Log.d("SignIn", exception.toString())
            }
        }


    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                //Sign in done
                Toast.makeText(this, "SignIn SuccessFull", Toast.LENGTH_SHORT).show()
            } else {
                //Sign in failed
                Toast.makeText(this, "SignIn Failed", Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun signOut() {
        //Getting the google account
        val googleSignInClient: GoogleSignInClient
        //Client
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(androidx.compose.ui.R.string.default_error_message))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)


        //Signing out
        mAuth.signOut()
        googleSignInClient.signOut().addOnCompleteListener {
            setContent() {
                //OpretBruger(navController = n) {

            }

        }.addOnFailureListener {
            Toast.makeText(this, "Sign out failed", Toast.LENGTH_SHORT).show()
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

