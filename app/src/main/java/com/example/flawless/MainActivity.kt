package com.example.flawless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flawless.homepage.HomePageOff
import com.example.flawless.ui.theme.FlawlessTheme
import com.example.flawless.welcomepage.FirstPage
import com.example.flawless.welcomepage.LoginPage
import com.example.flawless.welcomepage.SignUpPage
import com.example.flawless.welcomepage.WelcomePage
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlawlessTheme {
                // Scaffold provides the basic structure and handles system bars padding
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // AppNavigation will place its screens within this Scaffold's content area
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

object AppDestinations {
    const val FIRST_PAGE = "first_page"
    // WELCOME_PAGE akan menjadi halaman yang berisi tombol Create Account dan Log In
    const val WELCOME_PAGE = "welcome_page"
    const val SIGN_UP_PAGE = "sign_up_page" // Rute baru
    const val LOGIN_PAGE = "login_page"
    const val HOME_PAGE = "home_page"
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestinations.FIRST_PAGE,
        modifier = modifier // Apply the padding from Scaffold to the NavHost
    ) {
        composable(AppDestinations.FIRST_PAGE) {
            FirstPageWithDelay(
                navController = navController,
                // If FirstPageWithDelay's root should fill, apply modifier here
                // For now, assuming FirstPage itself handles its sizing via its own modifier
            )
        }
        composable(AppDestinations.WELCOME_PAGE) {
            // Assuming Login composable from PageLogin.kt can take a modifier
            WelcomePage(
                modifier = Modifier.fillMaxSize(),
                navController = navController
            )
        }
        composable(AppDestinations.SIGN_UP_PAGE) {
            // Asumsikan SignUpPage adalah nama Composable di PageSignUp.kt
            SignUpPage(navController = navController, modifier = Modifier.fillMaxSize())
            // Jika SignUpPage tidak butuh NavController, cukup:
            // SignUpPage(modifier = Modifier.fillMaxSize())
        }
        composable(AppDestinations.LOGIN_PAGE) {
            LoginPage(
                navController = navController,
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(AppDestinations.HOME_PAGE) {
            HomePageOff(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun FirstPageWithDelay(
    navController: NavController,
    modifier: Modifier = Modifier // Accept a modifier
) {
    // LaunchedEffect will run the block when the composable enters composition.
    // `true` as a key means this effect runs once on initial composition.
    LaunchedEffect(key1 = true) {
        delay(5000L) // Wait for 5000 milliseconds (5 seconds)
        navController.navigate(AppDestinations.WELCOME_PAGE) {
            // Option to clear the back stack so the user cannot go back to FirstPage
            popUpTo(AppDestinations.FIRST_PAGE) {
                inclusive = true
            }
            launchSingleTop = true // Avoid creating a new instance if it's already on top
        }
    }
    // Display the FirstPage content.
    // Pass the modifier down, allowing FirstPage to decide how to use it.
    // If FirstPage is always meant to fill its container, it can apply .fillMaxSize() internally
    // or you can apply it here: FirstPage(modifier = modifier.fillMaxSize())
    FirstPage(modifier = modifier.fillMaxSize())
}

// Preview for the entire navigation flow starting point
@Preview(showBackground = true, name = "App Navigation Preview")
@Composable
fun DefaultAppPreview() {
    FlawlessTheme {
        // Simulate the padding Scaffold would provide
        AppNavigation()
    }
}

// Preview for the FirstPage specifically
@Preview(showBackground = true, name = "First Page Preview")
@Composable
fun FirstPageScreenPreview() {
    FlawlessTheme {
        FirstPage(modifier = Modifier.fillMaxSize())
    }
}

// Preview for the Login page specifically
// (Assuming you have a Login composable in com.example.flawless.welcomepage)
@Preview(showBackground = true, name = "Welcome Page Preview")
@Composable
fun WelcomePageScreenPreview() {
    FlawlessTheme {
        WelcomePage(
            modifier = Modifier.fillMaxSize(),
            navController = rememberNavController()
        )
    }
}