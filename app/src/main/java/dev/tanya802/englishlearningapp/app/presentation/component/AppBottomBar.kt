package dev.tanya802.englishlearningapp.app.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.tanya802.englishlearningapp.R
import dev.tanya802.englishlearningapp.ui.theme.DeepGray

enum class AppTab(
    val routeName: String,
    val displayName: String,
    val icon: Int
) {
    Home(
        routeName = "home",
        displayName = "Home",
        icon = R.drawable.ic_home,
    ),
    Library(
        routeName = "library",
        displayName = "Library",
        icon = R.drawable.ic_folder,
    )
}

@Composable
fun AppBottomTabBar(navigationController: NavHostController) {

    val currentRoute = navigationController.currentBackStackEntryAsState().value?.destination?.route

    Surface(
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 10.dp,
        tonalElevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBar(
            modifier = Modifier.height(84.dp),
            tonalElevation = 0.dp,
        ) {
            AppTab.entries.map { item ->
                AppNavigationBarItem(
                    modifier = Modifier.weight(1f),
                    icon = item.icon,
                    label = item.displayName,
                    isSelected = item.routeName == currentRoute,
                    onSelect = {
                        if (currentRoute != item.routeName) {
                            navigationController.navigate(item.routeName) {
                                popUpTo(navigationController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }
}


@Composable
fun AppNavigationBarItem(
    modifier: Modifier,
    icon: Int,
    label: String,
    isSelected: Boolean,
    onSelect: () -> Unit,
) {

    val activeColor = MaterialTheme.colorScheme.primary
    // TODO: fix colorScheme
    val disabledColor = DeepGray
    val actualColor = if (isSelected) activeColor else disabledColor

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxHeight()
            .clickable(
                onClick = { onSelect() },
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ),
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = label,
            tint = actualColor,
            modifier = Modifier.size(26.dp)
        )
        Text(
            modifier = Modifier.padding(top = 2.dp),
            text = label,
            color = actualColor,
            style = MaterialTheme.typography.labelMedium
        )
    }
}