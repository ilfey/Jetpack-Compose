package com.ilfey.wc.navigation

sealed class Routes(val route: String) {
    object SignInScreen : Routes("SignInScreen")
    object SignUpScreen : Routes("SignUpScreen")
    object MainScreen : Routes("MainScreen")
}