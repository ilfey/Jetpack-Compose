package com.ilfey.wc.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ilfey.wc.navigation.BottomNavRoutes
import com.ilfey.wc.ui.components.navigation.MainScreenNavigationConfiguration
import com.ilfey.wc.ui.theme.WorldCinemaTheme
import com.ilfey.wc.ui.theme.navBarColor
import com.ilfey.wc.ui.theme.navBarItemColors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val systemUiController = rememberSystemUiController()
            WorldCinemaTheme {
                SideEffect {
                    systemUiController.setNavigationBarColor(
                        color = Color(0xFF1C1A19)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    MainScreenNavigationConfiguration(navHostController = navController)

                    var currentScreen by remember { mutableStateOf(0) }
                    val screens = listOf(
                        BottomNavRoutes.MainScreen,
                        BottomNavRoutes.RecommendationsScreen,
                        BottomNavRoutes.CollectionsScreen,
                        BottomNavRoutes.ProfileScreen,
                    )

                    NavigationBar(
                        containerColor = navBarColor,
                        contentColor = navBarColor,
                    ) {
                        screens.forEachIndexed { index, page ->
                            NavigationBarItem(
                                icon = {
                                    Icon(imageVector = page.icon, contentDescription = page.title)
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
                }
            }
        }
    }
}