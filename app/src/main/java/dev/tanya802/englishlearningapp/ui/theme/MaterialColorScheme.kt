package dev.tanya802.englishlearningapp.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val LightColorScheme = lightColorScheme(

    // Primary brand color — cold medium blue
    primary = Blue40,
    onPrimary = Color.White,

    // Light blue container for buttons, highlights, selections
    primaryContainer = Blue80,
    onPrimaryContainer = Neutral10,

    // Secondary accent — muted indigo (used sparingly)
    secondary = Indigo40,
    onSecondary = Color.White,

    // Light indigo container for secondary actions
    secondaryContainer = Indigo80,
    onSecondaryContainer = Neutral10,

    // Screen background — very light cool neutral
    background = Neutral98,
    onBackground = Neutral10,

    // Card / sheet surface — pure white
    surface = Neutral100,
    onSurface = Neutral20,

    // Secondary surface — light gray-blue for lists, dividers
    surfaceVariant = Neutral90,
    onSurfaceVariant = Neutral40,

    // Outline / borders — soft neutral gray
    outline = Neutral70,

    // Error — soft but clear red
    error = Error40,
    onError = Color.White,

    // Error container — very light red background
    errorContainer = Error80,
    onErrorContainer = Neutral10
)


val DarkColorScheme = darkColorScheme(

    // Primary brand color for dark theme — light cold blue
    primary = Blue80,
    onPrimary = Neutral10Dark,

    // Darker blue container for highlighted surfaces
    primaryContainer = Blue20,
    onPrimaryContainer = Neutral90Dark,

    // Secondary accent — light indigo for dark theme
    secondary = Indigo80,
    onSecondary = Neutral10Dark,

    // Dark indigo container for secondary actions
    secondaryContainer = Indigo20,
    onSecondaryContainer = Neutral90Dark,

    // Screen background — dark cool navy
    background = Neutral10Dark,
    onBackground = Neutral90Dark,

    // Card / sheet surface — slightly lighter than background
    surface = Neutral20Dark,
    onSurface = Neutral80Dark,

    // Secondary surface — elevated dark surface
    surfaceVariant = Neutral30Dark,
    onSurfaceVariant = Neutral60Dark,

    // Outline / borders — muted blue-gray
    outline = Neutral50Dark,

    // Error — same red tone, readable on dark background
    error = Error40,
    onError = Color.White,

    // Error container — dark surface with error context
    errorContainer = Error40,
    onErrorContainer = Neutral90Dark
)
