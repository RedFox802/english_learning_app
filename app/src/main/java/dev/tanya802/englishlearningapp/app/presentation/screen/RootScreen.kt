package dev.tanya802.englishlearningapp.app.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.tanya802.englishlearningapp.app.presentation.component.AppBottomBar
import dev.tanya802.englishlearningapp.app.presentation.component.BottomNavRoute
import dev.tanya802.englishlearningapp.feature.home.presentation.screen.HomeScreen
import dev.tanya802.englishlearningapp.feature.library.presentation.screen.LibraryScreen
import dev.tanya802.englishlearningapp.ui.theme.EnglishLearningAppTheme

@Composable
fun RootScreen() {

    val navController = rememberNavController()

    EnglishLearningAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                AppBottomBar(navController)
            }
        ) { innerPadding ->

            val homeRoute = BottomNavRoute.Home.routeName
            val actualModifier = Modifier.padding(innerPadding);
            NavHost(
                navController = navController,
                startDestination = homeRoute,
                modifier = actualModifier
            ) {
                composable(homeRoute) {
                    HomeScreen(actualModifier)
                }
                composable(BottomNavRoute.Library.routeName) {
                    LibraryScreen(actualModifier)
                }
            }
        }
    }
}

