package com.ilfey.wc.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AuthRoutes(val route: String) {
    object SignInScreen : AuthRoutes("SignInScreen")
    object SignUpScreen : AuthRoutes("SignUpScreen")
}

sealed class BottomNavRoutes(val route: String, val icon: ImageVector,val title: String, val index: Int) {
    object MainScreen : BottomNavRoutes("MainScreen", Icons.Filled.Home, "Главное", 0)
    object RecommendationsScreen : BottomNavRoutes("RecommendationsScreen", Icons.Rounded.AccountBox,"Подборка", 1)
    object CollectionsScreen : BottomNavRoutes("CollectionsScreen", Icons.Rounded.Star,"Коллекции", 2)
    object ProfileScreen : BottomNavRoutes("ProfileScreen", Icons.Outlined.Person, "Профиль", 3)
}
