package com.box.spendbasetestapp.presentation.features.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.box.spendbasetestapp.presentation.features.home.HomeRoute

const val HOME_ROUTE = "home_route"

fun NavController.navigateToHomeScreen(navOptions: NavOptions) = navigate(HOME_ROUTE, navOptions)

fun NavGraphBuilder.homeScreen(
    onNavigateToCardDetails: (String) -> Unit
) {
    composable(route = HOME_ROUTE) {
        HomeRoute(
            onNavigateToCardDetails = onNavigateToCardDetails
        )
    }
}
