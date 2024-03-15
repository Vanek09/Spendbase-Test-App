package com.box.spendbasetestapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

val LocalTypography = staticCompositionLocalOf {
    Typography(
        bodyLarge = TextStyle.Default,
        bodyMedium = TextStyle.Default,
        bodySmall = TextStyle.Default,
        labelLarge = TextStyle.Default,
        labelMedium = TextStyle.Default,
        labelSmall = TextStyle.Default,
        titleLarge = TextStyle.Default,
        titleMedium = TextStyle.Default,
        titleSmall = TextStyle.Default,
        headlineLarge = TextStyle.Default,
        headlineMedium = TextStyle.Default,
        headlineSmall = TextStyle.Default,
        navTapLabel = TextStyle.Default
    )
}

val LocalColors = staticCompositionLocalOf {
    Colors(
        primary = white,
        secondary = black,
    )
}

@Composable
fun SpendbaseTestAppTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides typography,
        LocalColors provides lightColors,
    ) {
        content()
    }
}

object SpendbaseTestAppTheme {
    val typography: Typography
        @Composable
        get() = LocalTypography.current

    val colors: Colors
        @Composable
        get() = LocalColors.current

}
