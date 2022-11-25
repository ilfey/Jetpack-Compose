package com.ilfey.wc.ui.components.navigation

import com.ilfey.wc.navigation.AuthRoutes
import com.ilfey.wc.ui.screens.SignInScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ilfey.wc.navigation.BottomNavRoutes
import com.ilfey.wc.ui.screens.*
import com.ilfey.wc.viewmodel.SignInViewModel


@Composable
fun AuthScreenNavigationConfiguration(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = AuthRoutes.SignInScreen.route
    ) {

        composable(AuthRoutes.SignInScreen.route) {
            val viewModel = hiltViewModel<SignInViewModel>()

            SignInScreen(
                viewModel = viewModel
            ) {
                navHostController.navigate(it) {
                    launchSingleTop = true
                }
            }
        }

        composable(AuthRoutes.SignUpScreen.route) {
            SignUpScreen {
                if (it == AuthRoutes.SignInScreen.route)
                    navHostController.popBackStack()
                else
                    navHostController.navigate(it)
            }
        }
    }
}

@Composable
fun MainScreenNavigationConfiguration(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavRoutes.MainScreen.route
    ) {

        composable(BottomNavRoutes.MainScreen.route) {
            MainScreen()
        }

        composable(BottomNavRoutes.RecommendationsScreen.route) {
            RecommendationsScreen()
        }

        composable(BottomNavRoutes.CollectionsScreen.route) {
            CollectionsScreen()
        }

        composable(BottomNavRoutes.ProfileScreen.route) {
            ProfileScreen()
        }
    }
}