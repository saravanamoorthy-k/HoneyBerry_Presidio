package com.presidio.honeyberry.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val GrayPrimary = Color(0xFF575757)
private val GraySecondary = Color(0xFF949494)
private val Background = Color(0xFFFCFCFC)
private val Green = Color(0xFF55C595)
private val DarkGreen = Color(0xFF289460)

val LightColorsPalette = HoneyBerryColors(
    text = GraySecondary,
    textDark = GrayPrimary,
    textDarkGreen = DarkGreen,
    textLight = Color.White,
    buttonSelected = Green,
    buttonUnselected = Color.White,
    background = Background,
    chipsBackground = Color.White,
    snackBarBackground = GrayPrimary
)

@Stable
data class HoneyBerryColors(
    val text: Color,
    val textDark: Color,
    val textLight: Color,
    val textDarkGreen: Color,

    val buttonSelected: Color,
    val buttonUnselected: Color,

    val background: Color,
    val chipsBackground: Color,
    val snackBarBackground: Color
)

internal val LocalHoneyBerryColors = staticCompositionLocalOf { LightColorsPalette }

@Composable
internal fun ProvideHoneyBerryColors(
    colors: HoneyBerryColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalHoneyBerryColors provides colors, content = content)
}

/**
 * A Material [Colors] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colors] in preference to [VendorAppTheme.colors].
 */
internal fun debugColors(
    darkTheme: Boolean = false,
    debugColor: Color = Color.White
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)