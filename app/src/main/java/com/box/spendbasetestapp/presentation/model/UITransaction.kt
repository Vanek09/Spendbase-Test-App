package com.box.spendbasetestapp.presentation.model

import java.time.LocalDateTime

data class UITransaction(
    val id: String,
    val card: UICard?,
    val amount: Double,
    val isAttached: Boolean,
    val completeDate: LocalDateTime,
)