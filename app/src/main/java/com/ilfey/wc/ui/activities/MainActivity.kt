package com.ilfey.wc.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ilfey.wc.navigation.BottomNavRoutes
import com.ilfey.wc.ui.components.navigation.MainScreenNavigationConfiguration
import com.ilfey.wc.ui.theme.WorldCinemaTheme
import com.ilfey.wc.ui.theme.navBarColor
import com.ilfey.wc.ui.theme.navBarItemColors


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val systemUiController = rememberSystemUiController()
            var currentScreen by remember { mutableStateOf(0) }
            val screens = listOf(
                BottomNavRoutes.MainScreen,
                BottomNavRoutes.RecommendationsScreen,
                BottomNavRoutes.CollectionsScreen,
                BottomNavRoutes.ProfileScreen,
            )
            WorldCinemaTheme {
                SideEffect {
                    systemUiController.setNavigationBarColor(
                        color = Color(0xFF1C1A19)
                    )
                }
                Scaffold(
                    content = { MainScreenNavigationConfiguration(navHostController = navController) },
                    bottomBar = {
                        NavigationBar(
                            containerColor = navBarColor,
                            contentColor = navBarColor,
                        ) {
                            screens.forEachIndexed { index, page ->
                                NavigationBarItem(
                                    icon = {
                                        Icon(
                                            imageVector = page.icon,
                                            contentDescription = page.title
                                        )
                                    },
                                    label = {
                                        Text(
                                            text = page.title,
                                            fontSize = 12.sp,
                                        )
                                    },
                                    alwaysShowLabel = true,
                                    selected = currentScreen == page.index,
                                    onClick = {
                                        currentScreen = index
                                        navController.navigate(page.route)
                                    },
                                    colors = navBarItemColors()
                                )
                            }
                        }
                    },
                )
            }
        }
    }
}