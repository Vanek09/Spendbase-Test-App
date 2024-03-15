package com.box.spendbasetestapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.box.spendbasetestapp.presentation.features.account.navigation.accountScreen
import com.box.spendbasetestapp.presentation.features.card_details.navigation.cardDetailsScreen
import com.box.spendbasetestapp.presentation.features.card_details.navigation.navigateToCardDetailsScreen
import com.box.spendbasetestapp.presentation.features.home.navigation.HOME_ROUTE
import com.box.spendbasetestapp.presentation.features.home.navigation.homeScreen
import com.box.spendbasetestapp.presentation.features.my_cards.navigation.myCardsScreen
import com.box.spendbasetestapp.presentation.features.transactions.navigation.transactionsScreen
import com.box.spendbasetestapp.presentation.main.MainScreenState

@Composable
fun SpendbaseNavHost(
    mainScreenState: MainScreenState,
    modifier: Modifier = Modifier,
    startDestination: String = HOME_ROUTE,
) {
    val navController = mainScreenState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeScreen(
            onNavigateToCardDetails = navController::navigateToCardDetailsScreen
        )
        transactionsScreen()
        myCardsScreen()
        accountScreen()
        cardDetailsScreen(
            onBackClick = navController::popBackStack
        )
    }
}
