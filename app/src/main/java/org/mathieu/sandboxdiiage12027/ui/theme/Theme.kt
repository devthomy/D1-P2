package org.mathieu.sandboxdiiage12027.ui.theme

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.core.view.WindowCompat
import org.mathieu.sandboxdiiage12027.R


//private val DarkColorScheme = darkColorScheme(
//    primary = blue_whale,
//    secondary = PurpleGrey80
//)

private val DarkColorScheme
    @Composable
    get() = darkColorScheme(
        primary = colorResource(id = R.color.primary),
        onPrimary = colorResource(id = R.color.onPrimary),
        secondary = colorResource(id = R.color.secondary),
        onSecondary = colorResource(id = R.color.onSecondary),
        background = colorResource(id = R.color.background),
        onBackground = colorResource(id = R.color.onBackground)
    )

private val LightColorScheme
    @Composable
    get() = lightColorScheme(
        primary = colorResource(id = R.color.primary),
        onPrimary = colorResource(id = R.color.onPrimary),
        secondary = colorResource(id = R.color.secondary),
        onSecondary = colorResource(id = R.color.onSecondary),
        background = colorResource(id = R.color.background),
        onBackground = colorResource(id = R.color.onBackground)
    )

@Composable
fun LeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
        }

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
        typography = Typography,
        content = content
    )
}