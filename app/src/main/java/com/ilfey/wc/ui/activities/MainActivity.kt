package com.ilfey.wc.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.ilfey.wc.navigation.BottomNavRoutes
import com.ilfey.wc.ui.components.navigation.MainScreenNavigationConfiguration
import com.ilfey.wc.ui.theme.WorldCinemaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            WorldCinemaTheme {
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

                    NavigationBar {
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
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}