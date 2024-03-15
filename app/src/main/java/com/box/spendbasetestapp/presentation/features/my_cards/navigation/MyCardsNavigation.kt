package com.box.spendbasetestapp.presentation.features.my_cards.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.box.spendbasetestapp.presentation.features.my_cards.MyCardsRoute

const val MY_CARDS_ROUTE = "my_cards_route"

fun NavController.navigateToMyCardsScreen(navOptions: NavOptions) = navigate(MY_CARDS_ROUTE, navOptions)

fun NavGraphBuilder.myCardsScreen(
) {
    composable(route = MY_CARDS_ROUTE) {
        MyCardsRoute()
    }
}
