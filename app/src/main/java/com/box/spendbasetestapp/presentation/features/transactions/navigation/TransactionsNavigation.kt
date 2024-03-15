package com.box.spendbasetestapp.presentation.features.transactions.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.box.spendbasetestapp.presentation.features.transactions.TransactionsRoute

const val TRANSACTIONS_ROUTE = "transactions_route"

fun NavController.navigateToTransactionsScreen(navOptions: NavOptions) = navigate(TRANSACTIONS_ROUTE, navOptions)

fun NavGraphBuilder.transactionsScreen(
) {
    composable(route = TRANSACTIONS_ROUTE) {
        TransactionsRoute()
    }
}
