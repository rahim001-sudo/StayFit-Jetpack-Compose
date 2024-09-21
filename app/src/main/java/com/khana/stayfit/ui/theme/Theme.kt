package com.khana.stayfit.ui.theme

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
    primary = Color(0xff8c66f3),
    secondary = colorB6B4C1,
    tertiary = color983BCB,
    background = color2A2C38,
    onTertiary = color4023D7,
    onPrimary = Color(0xffe9e3e4),
    onSecondary = Color(0xff161818),
    primaryContainer = Color(0xffACA3A5),
    onBackground = Color(0xff7e7476),
    surface = Color(0xff494345),
    onSurface = Color(0xffc75af2),
    onError = Color(0xff423c3d),
    errorContainer = Color(0xff9c23d7),
    onErrorContainer = Color(0xff962e6e),
    surfaceContainer = Color(0xff73717e),
    onSurfaceVariant = Color(0xffEEA4CE),
    onTertiaryContainer = Color(0xffC050F6),
    onSecondaryContainer = Color(0xffFFFFFF)
)

private val LightColorScheme = lightColorScheme(
    primary = color2A2C38,
    secondary = color983BCB,
    tertiary = color4023D7,
    background = color2A2C38,
)

@Composable
fun ComposePagerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme =DarkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography(AppFont.fontFamily),
        content = content,
    )
}


@Composable
fun StayFitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
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
        typography = typography(AppFont.fontFamily),
        content = content
    )
}