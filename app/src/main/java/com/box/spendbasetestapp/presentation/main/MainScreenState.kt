package com.box.spendbasetestapp.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.box.spendbasetestapp.presentation.features.account.navigation.ACCOUNT_ROUTE
import com.box.spendbasetestapp.presentation.features.account.navigation.navigateToAccountScreen
import com.box.spendbasetestapp.presentation.features.home.navigation.HOME_ROUTE
import com.box.spendbasetestapp.presentation.features.home.navigation.navigateToHomeScreen
import com.box.spendbasetestapp.presentation.features.my_cards.navigation.MY_CARDS_ROUTE
import com.box.spendbasetestapp.presentation.features.my_cards.navigation.navigateToMyCardsScreen
import com.box.spendbasetestapp.presentation.features.transactions.navigation.TRANSACTIONS_ROUTE
import com.box.spendbasetestapp.presentation.features.transactions.navigation.navigateToTransactionsScreen
import com.box.spendbasetestapp.presentation.navigation.TopLevelDestination
import com.box.spendbasetestapp.presentation.navigation.TopLevelDestination.*

@Stable
class MainScreenState(
    val navController: NavHostController
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            HOME_ROUTE -> HOME
            TRANSACTIONS_ROUTE -> TRANSACTIONS
            MY_CARDS_ROUTE -> MY_CARDS
            ACCOUNT_ROUTE -> ACCOUNT
            else -> null
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            HOME -> navController.navigateToHomeScreen(topLevelNavOptions)
            TRANSACTIONS -> navController.navigateToTransactionsScreen(topLevelNavOptions)
            MY_CARDS -> navController.navigateToMyCardsScreen(topLevelNavOptions)
            ACCOUNT -> navController.navigateToAccountScreen(topLevelNavOptions)
        }

    }
}

@Composable
fun rememberMainScreenState(
    navController: NavHostController = rememberNavController(),
): MainScreenState {
    return remember(
        navController
    ) {
        MainScreenState(
            navController = navController
        )
    }
}