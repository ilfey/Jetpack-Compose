package com.ilfey.wc.ui.theme

import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val primary = Color(0xFFEF3A01)
val secondary = Color(0xFFFFFFFF)
val tertiary = Color(0xFFFFFFFF)

val background = Color(0xFF332973)
val surface = Color(0xFFFFFBFE)
val onPrimary = Color(0xFFFFFFFF)
val onSecondary = Color(0xFFFFFFFF)
val onTertiary = Color(0xFFFFFFFF)
val onBackground = Color(0xFF1C1B1F)
val onSurface = Color(0xFF1C1B1F)
val tabsContainer = Color(0x0AC4C4C4)


@Composable
fun navBarItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = primary,
    selectedTextColor = primary,
    indicatorColor = navBarColor,
    unselectedIconColor = Color(0xFF757575),
    unselectedTextColor = Color(0xFF757575),
)

val navBarColor = Color(0xFF1C1A19)
val text = Color(0xFFA8A8A8)