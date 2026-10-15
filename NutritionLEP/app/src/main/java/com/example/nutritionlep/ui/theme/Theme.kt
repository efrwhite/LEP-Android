package com.example.nutritionlep.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BrightMint,
    onPrimary = DeepForest,
    secondary = SageGreen,
    background = DeepForest,
    surface = DeepForest,
    onBackground = OffWhite,
    onSurface = OffWhite
)

private val LightColorScheme = lightColorScheme(
    primary = DarkGreen,
    onPrimary = OffWhite,
    secondary = BrightMint,
    onSecondary = OffWhite,
    tertiary = TealGreen,
    background = LightMint,
    onBackground = DarkGreen,
    surface = OffWhite,
    onSurface = DarkGreen
)

@Composable
fun NutritionLEPTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is disabled so your custom palette always shows
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}