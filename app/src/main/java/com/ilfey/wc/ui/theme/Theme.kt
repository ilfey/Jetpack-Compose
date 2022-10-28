package com.ilfey.wc.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorScheme = lightColorScheme(
    primary = primary,
    secondary = secondary,
    tertiary = tertiary,
    background = background,
    surface = surface,
    onPrimary = onPrimary,
    onSecondary = onSecondary,
    onTertiary = onTertiary,
    onBackground = onBackground,
    onSurface = onSurface,

)

@Composable
fun WorldCinemaTheme(
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val colorScheme = LightColorScheme
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
        }
    }

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )


}