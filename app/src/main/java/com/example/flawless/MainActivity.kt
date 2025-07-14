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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flawless.homepage.CreatePage
import com.example.flawless.homepage.DetailPost
import com.example.flawless.homepage.HomePage1
import com.example.flawless.homepage.HomePageOff
import com.example.flawless.profile.ProfileAddAccount
import com.example.flawless.profile.ProfilePage
import com.example.flawless.profile.ProfileSecurity
import com.example.flawless.profile.ProfileSetting
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

object AppDestinations {
    const val FIRST_PAGE = "first_page"
    const val WELCOME_PAGE = "welcome_page"
    const val SIGN_UP_PAGE = "sign_up_page"
    const val LOGIN_PAGE = "login_page"
    const val HOME_PAGE_OFF = "home_page_off"
    const val HOME_PAGE_1 = "home_page_1"
    const val CREATE_PAGE = "create_page"
    const val PROFILE_PAGE = "profile_page"
    const val DETAIL_POST_PAGE = "detail_post_page"
    const val PROFILE_SETTINGS_PAGE = "profile_settings_page"
    const val SECURITY_PAGE = "security_page"
    const val ADD_ACCOUNT_PAGE = "add_account_page"
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestinations.FIRST_PAGE,
        modifier = modifier
    ) {
        composable(AppDestinations.FIRST_PAGE) {
            FirstPageWithDelay(
                navController = navController,
            )
        }
        composable(AppDestinations.WELCOME_PAGE) {
            WelcomePage(
                modifier = Modifier.fillMaxSize(),
                navController = navController
            )
        }
        composable(AppDestinations.SIGN_UP_PAGE) {
            SignUpPage(
                navController = navController,
                modifier = Modifier.fillMaxSize(),
                authViewModel = viewModel()
            )
        }
        composable(AppDestinations.LOGIN_PAGE) {
            LoginPage(
                navController = navController,
                modifier = Modifier.fillMaxSize()
            )
        }
        composable(AppDestinations.HOME_PAGE_OFF) {
            HomePageOff(
                navController = navController,
                modifier = Modifier.fillMaxSize())
        }
        composable(AppDestinations.HOME_PAGE_1) {
            HomePage1(
                navController = navController,
                modifier = Modifier.fillMaxSize())
        }
        composable(AppDestinations.CREATE_PAGE) {
            CreatePage(
                navController = navController,
                modifier = Modifier.fillMaxSize())
        }
        composable(AppDestinations.PROFILE_PAGE) {
            ProfilePage(
                navController = navController,
                modifier = Modifier.fillMaxSize())
        }
        composable(AppDestinations.DETAIL_POST_PAGE) {
            DetailPost(
                navController = navController,
                modifier = Modifier.fillMaxSize())
        }
        composable(AppDestinations.PROFILE_SETTINGS_PAGE) {
            ProfileSetting(
                navController = navController,
                modifier = Modifier.fillMaxSize())
        }
        composable(AppDestinations.SECURITY_PAGE) {
            ProfileSecurity(
                navController = navController,
                modifier = Modifier.fillMaxSize())
        }
        composable(AppDestinations.ADD_ACCOUNT_PAGE) {
            ProfileAddAccount(
                navController = navController,
                modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun FirstPageWithDelay(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(key1 = true) {
        delay(3000L)
        navController.navigate(AppDestinations.WELCOME_PAGE) {
            popUpTo(AppDestinations.FIRST_PAGE) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
    FirstPage(modifier = modifier.fillMaxSize())
}

// Preview for the entire navigation
@Preview(showBackground = true, name = "App Navigation Preview")
@Composable
fun DefaultAppPreview() {
    FlawlessTheme {
        AppNavigation()
    }
}

// Preview for the FirstPage
@Preview(showBackground = true, name = "First Page Preview")
@Composable
fun FirstPageScreenPreview() {
    FlawlessTheme {
        FirstPage(modifier = Modifier.fillMaxSize())
    }
}

// Preview for the Login page specifically
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