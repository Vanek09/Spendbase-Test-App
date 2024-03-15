package com.box.spendbasetestapp.presentation.features.account

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.box.spendbasetestapp.ui.theme.SpendbaseTestAppTheme

@Composable
fun AccountRoute() {
    AccountScreen()
}

@Composable
fun AccountScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Account Screen",
            style = SpendbaseTestAppTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}