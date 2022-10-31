package com.ilfey.wc.ui.screens.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ilfey.wc.R
import com.ilfey.wc.navigation.Routes
import com.ilfey.wc.ui.components.sign_in.SignInScreen
import com.ilfey.wc.ui.screens.MainScreen
import com.ilfey.wc.ui.screens.SignUpScreen
import com.ilfey.wc.ui.theme.WorldCinemaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_WorldCinema)

        setContent {
            val navController = rememberNavController()
            WorldCinemaTheme {
                NavHost(
                    navController = navController,
                    startDestination = Routes.SignInScreen.route
                ) {
                    composable(Routes.SignInScreen.route) { SignInScreen(navController = navController) }
                    composable(Routes.SignUpScreen.route) { SignUpScreen(navController = navController) }
                    composable(Routes.MainScreen.route) { MainScreen() }
                }
            }
        }
    }
}