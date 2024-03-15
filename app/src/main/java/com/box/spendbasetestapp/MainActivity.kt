package com.box.spendbasetestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.box.spendbasetestapp.presentation.main.MainScreen
import com.box.spendbasetestapp.presentation.main.rememberMainScreenState
import com.box.spendbasetestapp.ui.theme.SpendbaseTestAppTheme
import com.box.spendbasetestapp.ui.theme.white
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpendbaseTestAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = white
                ) {
                    val mainScreenState = rememberMainScreenState()

                    MainScreen(
                        mainScreenState = mainScreenState
                    )
                }
            }
        }
    }
}