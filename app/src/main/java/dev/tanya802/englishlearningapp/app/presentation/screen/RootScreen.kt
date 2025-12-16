package dev.tanya802.englishlearningapp.app.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.tanya802.englishlearningapp.app.presentation.component.AppBottomTabBar
import dev.tanya802.englishlearningapp.app.presentation.component.AppTab
import dev.tanya802.englishlearningapp.app.presentation.component.AppTopBar
import dev.tanya802.englishlearningapp.feature.home.presentation.screen.HomeScreen
import dev.tanya802.englishlearningapp.feature.library.presentation.screen.LibraryScreen
import dev.tanya802.englishlearningapp.ui.theme.EnglishLearningAppTheme

@Composable
fun RootScreen() {

    val navigationController = rememberNavController()

    val currentRoute =
        navigationController.currentBackStackEntryAsState().value?.destination?.route

    val currentTab = AppTab.entries.firstOrNull { it.routeName == currentRoute } ?: AppTab.Home


    EnglishLearningAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AppTopBar(title = currentTab.displayName)
            },
            bottomBar = {
                AppBottomTabBar(navigationController)
            }
        ) { innerPadding ->
            val homeRoute = AppTab.Home.routeName
            val actualModifier = Modifier.padding(innerPadding);
            NavHost(
                navController = navigationController,
                startDestination = homeRoute,
                modifier = actualModifier
            ) {
                composable(homeRoute) {
                    HomeScreen(actualModifier)
                }
                composable(AppTab.Library.routeName) {
                    LibraryScreen(actualModifier)
                }
            }
        }
    }
}

