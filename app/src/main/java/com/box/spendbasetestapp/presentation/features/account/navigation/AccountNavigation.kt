package com.box.spendbasetestapp.presentation.features.account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.box.spendbasetestapp.presentation.features.account.AccountRoute

const val ACCOUNT_ROUTE = "account_route"

fun NavController.navigateToAccountScreen(navOptions: NavOptions) = navigate(ACCOUNT_ROUTE, navOptions)

fun NavGraphBuilder.accountScreen(
) {
    composable(route = ACCOUNT_ROUTE) {
        AccountRoute()
    }
}
