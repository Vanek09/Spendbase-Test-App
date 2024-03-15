package com.box.spendbasetestapp.presentation.features.card_details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.box.spendbasetestapp.presentation.features.card_details.CardDetailsRoute

const val CARD_ID_ARG = "cardId"
const val CARD_DETAILS_BASE_ROUTE = "card_details_route"
const val CARD_DETAILS_ROUTE = "${CARD_DETAILS_BASE_ROUTE}/{$CARD_ID_ARG}"

fun NavController.navigateToCardDetailsScreen(cardId: String, navOptions: NavOptions? = null) {
    val route = "${CARD_DETAILS_BASE_ROUTE}/$cardId"
    navigate(route, navOptions)
}
fun NavGraphBuilder.cardDetailsScreen(
    onBackClick: () -> Unit,
) {
    composable(
        route = CARD_DETAILS_ROUTE,
        arguments = listOf(
            navArgument(CARD_ID_ARG) {
                defaultValue = ""
                nullable = true
                type = NavType.StringType
            }
        )
    ) {
        CardDetailsRoute(
            onBackClick,
            cardId = it.arguments?.getString(CARD_ID_ARG) ?: ""
        )
    }
}
