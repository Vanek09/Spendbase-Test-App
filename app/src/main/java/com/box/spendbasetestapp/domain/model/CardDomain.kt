package com.box.spendbasetestapp.domain.model

import java.time.LocalDateTime

data class CardDomain(
    val cardLast4: String,
    val cardName: String,
    val fundingSource: String,
    val id: String,
    val isLocked: Boolean,
    val isTerminated: Boolean,
    val issuedAt: LocalDateTime,
    val limit: Int,
    val limitType: String,
    val spent: Int,
    val cardHolderEmail: String,
    val cardHolderFullName: String,
    val cardHolderId: String,
    val cardHolderLogoUrl: String
)