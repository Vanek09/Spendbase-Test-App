package com.box.spendbasetestapp.presentation.features.my_cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.box.spendbasetestapp.ui.theme.SpendbaseTestAppTheme

@Composable
fun MyCardsRoute() {
    MyCardsScreen()
}

@Composable
fun MyCardsScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "My Cards",
            style = SpendbaseTestAppTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}