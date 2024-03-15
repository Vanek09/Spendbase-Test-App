package com.box.spendbasetestapp.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.box.spendbasetestapp.presentation.navigation.SpendbaseNavHost
import com.box.spendbasetestapp.presentation.navigation.TopLevelDestination
import com.box.spendbasetestapp.ui.theme.SpendbaseTestAppTheme
import com.box.spendbasetestapp.ui.theme.blue500
import com.box.spendbasetestapp.ui.theme.neutral100
import com.box.spendbasetestapp.ui.theme.neutral400
import com.box.spendbasetestapp.ui.theme.white

@Composable
fun MainScreen(
    mainScreenState: MainScreenState
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(), contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            NavigationBar(
                containerColor = white
            ) {
                mainScreenState.topLevelDestinations.forEach { destination ->
                    val selected =
                        mainScreenState.currentDestination.isTopLevelDestinationInHierarchy(
                            destination
                        )

                    NavigationBarItem(
                        selected = selected,
                        onClick = { mainScreenState.navigateToTopLevelDestination(destination) },
                        icon = {
                            Icon(
                                painter = painterResource(id = destination.icon),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(id = destination.titleId),
                                style = SpendbaseTestAppTheme.typography.navTapLabel,
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = blue500,
                            unselectedIconColor = neutral400,
                            selectedTextColor = blue500,
                            unselectedTextColor = neutral400,
                            indicatorColor = white
                        )
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(neutral100)
                .padding(padding)
        ) {
            SpendbaseNavHost(mainScreenState = mainScreenState)
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
