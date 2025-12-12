package dev.tanya802.englishlearningapp.app.presentation.component

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

enum class BottomNavRoute(
    val routeName: String,
    val displayName: String
) {
    Home(
        routeName = "home",
        displayName = "Home"
    ),
    Library(
        routeName = "library",
        displayName = "Library"
    )
}

@Composable
fun AppBottomBar(navController: NavHostController) {

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    return NavigationBar {
        BottomNavRoute.entries.forEach { item ->
            val isSelected = currentDestination?.route == item.routeName
            NavigationBarItem(
                selected = isSelected,
                label = {
                    Text(item.displayName)
                },
                icon = {
                    Text(item.displayName.take(1))
                },
                onClick = {
                    if (!isSelected) {
                        navController.navigate(item.routeName) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
            )
        }
    }
}
