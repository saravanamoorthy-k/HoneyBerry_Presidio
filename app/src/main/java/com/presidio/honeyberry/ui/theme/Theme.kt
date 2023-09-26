package com.presidio.honeyberry.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun HoneyBerryTheme(
    content: @Composable () -> Unit
) {
    ProvideHoneyBerryColors(colors = LightColorsPalette) {
        DisableOverscroll {
            MaterialTheme(
                colors = debugColors(),
                typography = HoneyBerryTypography,
                shapes = Shapes
            ) {
                content()
            }
        }
    }
}

object VendorAppTheme {
    val colors: HoneyBerryColors
        @Composable
        get() = LocalHoneyBerryColors.current

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun DisableOverscroll(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalOverscrollConfiguration provides null, content = content)
}