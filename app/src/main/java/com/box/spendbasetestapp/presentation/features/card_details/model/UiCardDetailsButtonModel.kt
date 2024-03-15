package com.box.spendbasetestapp.presentation.features.card_details.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class UiCardDetailsButtonModel(
    @DrawableRes val iconId: Int,
    @StringRes val titleId: Int,
    val type: UiCardDetailsButtonType
)

enum class UiCardDetailsButtonType {
    DETAILS, LOCK, TERMINATE
}