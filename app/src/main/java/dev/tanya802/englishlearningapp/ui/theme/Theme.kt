package dev.tanya802.englishlearningapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun EnglishLearningAppTheme(
    isSystemDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val materialColorScheme = if (isSystemDarkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = materialColorScheme,
        typography = AppTypography,
        content = content
    )

}