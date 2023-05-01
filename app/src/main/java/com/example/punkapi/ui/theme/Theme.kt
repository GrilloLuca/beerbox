package com.example.punkapi.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFCAF32),
    secondary = Color(0xFF0A1419),
    tertiary = Color(0xFF1C2228),

    // Other default colors to override
    background = Color(0xFF0B181D),
    surface = Color(0xFF0B181D),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,

    surfaceVariant = Color(0xFF1A262C),
    onSurfaceVariant = Color(0xFF8C9395)

)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFCAF32),
    secondary = Color(0xFF0A1419),
    tertiary = Color(0xFF8A8A8A),

    // Other default colors to override
    background = Color(0xFF0B181D),
    surface = Color(0xFF0B181D),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,

    surfaceVariant = Color(0xFF1A262C),
    onSurfaceVariant = Color(0xFF8C9395)
)

@Composable
fun BeerBoxTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//        }
//    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}