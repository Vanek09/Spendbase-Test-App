package com.box.spendbasetestapp.presentation.features.transactions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.box.spendbasetestapp.ui.theme.SpendbaseTestAppTheme

@Composable
fun TransactionsRoute() {
    TransactionsScreen()
}

@Composable
fun TransactionsScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Transactions",
            style = SpendbaseTestAppTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}