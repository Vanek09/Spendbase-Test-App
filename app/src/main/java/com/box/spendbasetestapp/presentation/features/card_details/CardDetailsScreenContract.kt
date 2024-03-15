package com.box.spendbasetestapp.presentation.features.card_details

import com.box.spendbasetestapp.R
import com.box.spendbasetestapp.presentation.features.card_details.model.UiCardDetailsButtonModel
import com.box.spendbasetestapp.presentation.features.card_details.model.UiCardDetailsButtonType
import com.box.spendbasetestapp.presentation.model.UICard
import com.box.spendbasetestapp.presentation.model.UITransaction
import com.mobile.tripd2d.base.UiEffect
import com.mobile.tripd2d.base.UiEvent
import com.mobile.tripd2d.base.UiState
import java.time.LocalDate

class CardDetailsScreenContract {

    data class State(
        val isLoading: Boolean,
        val card: UICard?,
        val transactions: Map<LocalDate, List<UITransaction>>
    ) : UiState {

        val listOfButtons = listOf(
            UiCardDetailsButtonModel(
                iconId = R.drawable.ic_eye,
                titleId = R.string.details_title,
                type = UiCardDetailsButtonType.DETAILS
            ),
            UiCardDetailsButtonModel(
                iconId = R.drawable.ic_lock,
                titleId = R.string.lock_title,
                type = UiCardDetailsButtonType.LOCK
            ),
            UiCardDetailsButtonModel(
                iconId = R.drawable.ic_credit_card_close,
                titleId = R.string.terminate_title,
                type = UiCardDetailsButtonType.TERMINATE
            ),
        )

        companion object {
            fun initial() = State(
                isLoading = false,
                card = null,
                transactions = emptyMap()
            )
        }
    }

    sealed interface Event : UiEvent {
        data class FetchCardInfoById(val id: String) : Event
    }

    sealed interface Effect : UiEffect

}
