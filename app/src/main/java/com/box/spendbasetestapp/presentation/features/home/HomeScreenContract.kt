package com.box.spendbasetestapp.presentation.features.home

import com.box.spendbasetestapp.presentation.model.UICard
import com.box.spendbasetestapp.presentation.model.UITransaction
import com.mobile.tripd2d.base.UiEffect
import com.mobile.tripd2d.base.UiEvent
import com.mobile.tripd2d.base.UiState

class HomeScreenContract {

    data class State(
        val isLoading: Boolean,
        val last3cards: List<UICard>,
        val last3Transaction: List<UITransaction>
    ) : UiState {
        companion object {
            fun initial() = State(
                isLoading = false,
                last3cards = emptyList(),
                last3Transaction = emptyList()
            )
        }
    }

    sealed interface Event : UiEvent

    sealed interface Effect : UiEffect

}
